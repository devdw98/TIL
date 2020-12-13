#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <pthread.h>
#include <time.h>
#include <sqlite3.h>
#include<netinet/in.h>

#define PORT 9000
#define BUF_SIZE 1024
#define MAX_CLI 10
#define DB_NAME "project2.db"

void info();
void *handle_cli(void *arg);
void send_msg(int cli_fd, char* msg, int len);
int process_item(int cli_fd, char *msg);
void print_connect_log(struct sockaddr_in cli_addr);
void print_disconnect_log();
void process_admin(int cli_fd, char *msg);
void process_client(int cli_fd, char *msg);

/* 연결된 client 수 */
int cli_count = 0; 
/* 연결된 클라이언트의 fd 번호 배열 */
int cli_socks[MAX_CLI];
/* 연결할 client들의 배열 */
pthread_t thread[MAX_CLI];
/* 상호배제를 위한 mutex */
pthread_mutex_t mutx;
/* 시간 로그 기록 위한 t*/
struct tm *t; 
time_t timer;
/* sqlite3 접근 위한 데이터베이스와 statement 구조체 */
sqlite3 *database;
sqlite3_stmt *stmt;
/* 클라이언트에게 보내는 데이터 버퍼 */
char snd_data[BUF_SIZE];

int main(int argc, char *argv[]){
    pthread_t t_id;
    struct sockaddr_in server_addr; //서버 소켓 주소
    struct sockaddr_in client_addr; //클라이언트 소켓 주소
    int serv_fd, cli_fd; //서버, 클라이언트의 fd
    int client_addr_size; // 클라이언트 주소 사이즈

    /* initial mutex */
    pthread_mutex_init(&mutx, NULL); 

    /* initial database */
    if(sqlite3_open(DB_NAME, &database) != SQLITE_OK){
        perror("initial_database");
        exit(1);
    }

    /* create socket */
    if((serv_fd = socket(AF_INET, SOCK_STREAM, 0)) < 0){
        perror("socket");
        exit(1);
    }

    /* bind socket */
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    server_addr.sin_port = htons(PORT);

    if(bind(serv_fd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0){
        perror("bind");
        exit(1);
    }

    /* listen client */
    if(listen(serv_fd, MAX_CLI) < 0){
        perror("listen");
        exit(1);
    }
    info();
    while(1){
        t = localtime(&timer);
        /* accept client */
        client_addr_size = sizeof(client_addr);
        if((cli_fd = accept(serv_fd, (struct sockaddr*)&client_addr, &client_addr_size)) < 0){
            perror("accept");
            exit(1);
        }
        /* 클라이언트 접속 */
        pthread_mutex_lock(&mutx);
        cli_socks[cli_count++] = cli_fd;
        pthread_mutex_unlock(&mutx);

        pthread_create(&t_id, NULL, handle_cli, (void*)&cli_fd);
        pthread_detach(t_id);
        print_connect_log(client_addr);
    }

    /* close socket */
    close(serv_fd);
    sqlite3_close_v2(database);
    return 0;
}

void info(){
    system("clear");
    printf("************* info ****************\n");
    printf(" server port : %d \n",PORT);
    printf("***********************************\n");
}

void *handle_cli(void *arg){
    int cli_fd = *((int*)arg);
    char msg[BUF_SIZE];
    int len, i;
    
    /* client 줄 것 */
    while((len = recv(cli_fd, msg, sizeof(msg), 0))!=0){ //client가 보낸 데이터
        send_msg(cli_fd, msg, len);   
    }

    //remove disconnected client
    pthread_mutex_lock(&mutx);
    for(i = 0; i < cli_count; i++){
        if(cli_fd == cli_socks[i]){
            while(i++ < cli_count-1)
                cli_socks[i] = cli_socks[i+1];
            break;
        }
    }
    cli_count--;
    pthread_mutex_unlock(&mutx);
    print_disconnect_log();
    close(cli_fd);
    return NULL;
}

void send_msg(int cli_fd, char* msg, int len)
{
    int i;
    if(!strncmp(msg, "[notice]",8)){ // notice 모든 client에게 전달
        pthread_mutex_lock(&mutx); 
        for (i=0; i<cli_count; i++)
            send(cli_socks[i], msg, len, 0);
        pthread_mutex_unlock(&mutx);

    }else if(!strncmp(msg, "[admin]",7)){ //admin process
        char *ptr = strtok(msg,"[]\n");
        ptr = strtok(NULL,"[]\n");
        process_admin(cli_fd, ptr);
    }
    else{

        if(!strncmp(msg, "[", 1)){
           pthread_mutex_lock(&mutx);
            process_item(cli_fd, msg); //client 상품 주문 처리
           pthread_mutex_unlock(&mutx);
        }else{
        process_client(cli_fd, msg); //client 상품 조회
        } 
    }
}

int process_item(int cli_fd, char *msg){
    int data = 0;
    char *username;
    char *itemname;
    int count;
    int stock_quantity = 0;
    int price = 0;
    int sales = 0;
    char *buf[3];
    char *ptr = strtok(msg, ":\n");
    buf[0] = ptr;
    ptr = strtok(NULL, ":\n");
    buf[1] = ptr;
    ptr = strtok(NULL, ":\n");
    buf[2] = ptr;
    username = strtok(buf[0], "[]");
    itemname = buf[1];
    count = atoi(buf[2]);

    char *sql = "SELECT stock_quantity, price, sales FROM ITEM WHERE name = ?";
    char *sql2 = "UPDATE ITEM SET stock_quantity = ?, sales = ? WHERE NAME = ?";
    char *sql3 = "INSERT INTO orders(name, itemname, count, total_price) values (?,?,?,?)";

    /* select item to check for item */
    if(sqlite3_prepare_v2(database, sql, -1, &stmt, NULL) == SQLITE_OK){
        sqlite3_bind_text(stmt, 1, itemname, -1, SQLITE_TRANSIENT);
    }else{
        perror("no data");
        exit(1);
    }

    while(sqlite3_step(stmt) == SQLITE_ROW) {
        data++;
        stock_quantity = (int)sqlite3_column_int(stmt,0);
        price = (int)sqlite3_column_int(stmt, 1);
        sales = (int)sqlite3_column_int(stmt, 2);

        if(stock_quantity < count){
            sprintf(snd_data, "구매할 수 있는 수량 : %d\n", stock_quantity);
            send(cli_fd, snd_data, strlen(snd_data), 0);
            return 0;
        }
    }

    if(data == 0){
        sprintf(snd_data, "해당 상품이 존재하지 않습니다.\n");
        send(cli_fd, snd_data, strlen(snd_data), 0);
        return 0;
    }
    /* update item stock_quantity */
    sqlite3_reset(stmt);
    stock_quantity -= count;
    sales += count;
    if(sqlite3_prepare_v2(database, sql2, -1, &stmt, NULL) == SQLITE_OK){
        sqlite3_bind_int(stmt, 1, stock_quantity);
        sqlite3_bind_int(stmt, 2, sales);
        sqlite3_bind_text(stmt, 3, itemname, -1, SQLITE_TRANSIENT);
    }
    if(sqlite3_step(stmt) != SQLITE_DONE){
        sprintf(snd_data, "update error : forced termination\n");
        send(cli_fd, snd_data, strlen(snd_data), 0);
        perror("update item's stock_quantity");
        exit(1);
    }
    /* insert order */
    sqlite3_reset(stmt);
    if(sqlite3_prepare_v2(database, sql3, -1, &stmt, NULL) == SQLITE_OK){
        sqlite3_bind_text(stmt, 1, username, -1, SQLITE_TRANSIENT);
        sqlite3_bind_text(stmt, 2, itemname, -1, SQLITE_TRANSIENT);
        sqlite3_bind_int(stmt, 3, count);
        sqlite3_bind_int(stmt, 4, count * price);
    }else{
        sprintf(snd_data, "order error : forced termination\n");
        send(cli_fd, snd_data, strlen(snd_data), 0);
        perror("insert orders_");
        exit(1);
    }
    if(sqlite3_step(stmt) != SQLITE_DONE){
        perror("insert_order");
        exit(1);
    }else{
        sprintf(snd_data, "success order : %s - %d | total : %d\n", itemname, count, count * price);
        send(cli_fd, snd_data, strlen(snd_data), 0);
    }
    sqlite3_finalize(stmt); //statement 메모리 해제
    return 1;
}

void print_connect_log(struct sockaddr_in cli_addr){
    timer = time(NULL);
    t = localtime(&timer);
    printf(" connected client IP : %s \n", inet_ntoa(cli_addr.sin_addr));
    
    printf(" client access (%d/10) ", cli_count);
    printf("\t(%d-%d-%d %d:%d:%d)\n", t->tm_year+1900, t->tm_mon+1, t->tm_mday,
        t->tm_hour, t->tm_min, t->tm_sec);
}

void print_disconnect_log(){
    timer = time(NULL);
    t = localtime(&timer);
    printf(" client access (%d/10) ", cli_count);
    printf("\t(%d-%d-%d %d:%d:%d)\n", t->tm_year+1900, t->tm_mon+1, t->tm_mday,
        t->tm_hour, t->tm_min, t->tm_sec);
}

void process_admin(int cli_fd, char *msg){
    if(sqlite3_prepare_v2(database, msg, -1, &stmt, NULL) != SQLITE_OK){
        perror("item_database_prepare");
        exit(1);
    }
    if(!strncmp(msg, "SELECT", 6)){ //누적 판매량 TOP 3 조회
        char* name;
        int quantity;
        int price;
        while(sqlite3_step(stmt) == SQLITE_ROW){
            name = (char*)sqlite3_column_text(stmt, 0);
            quantity = (int)sqlite3_column_int(stmt, 1);
            price = (int)sqlite3_column_int(stmt, 2) * quantity;
            sprintf(snd_data, "| %s | %d | %d\n", name, quantity, price);
            send(cli_fd, snd_data, strlen(snd_data), 0);
        }
        sprintf(snd_data, "-------------------------------\n");
    }else{

        if(sqlite3_step(stmt) != SQLITE_DONE){
            perror("item_database");
            exit(1);
        }
        sprintf(snd_data, "success about database item.\n");
    }
    sqlite3_finalize(stmt);
    send(cli_fd, snd_data, strlen(snd_data), 0);
}

void process_client(int cli_fd, char *msg){
    char* name;
    int quantity;
    int price;
    int rc;
    char* ptr = strtok(msg, "\n");
    if((rc = sqlite3_prepare_v2(database, msg, -1, &stmt, NULL)) != SQLITE_OK){
        perror("process_client");
        exit(1);
    }
    
    while(sqlite3_step(stmt) == SQLITE_ROW){
        name = (char*)sqlite3_column_text(stmt, 0);
        quantity = (int)sqlite3_column_int(stmt, 1);
        price = (int)sqlite3_column_int(stmt, 2);
        sprintf(snd_data, "| %s | %d | %d\n", name, quantity, price);
        send(cli_fd, snd_data, strlen(snd_data), 0);
    }
    sqlite3_finalize(stmt);
    sprintf(snd_data, "-----------------\n");
}