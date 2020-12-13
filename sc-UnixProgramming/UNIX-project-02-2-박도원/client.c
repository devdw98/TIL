#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <pthread.h>
#include <time.h>

#define BUF_SIZE 1024
#define NORMAL_SIZE 20
#define ITEM_COUNT 5

void menu();
void menu_admin();
void process(int sock);
void process_admin(int sock);
void* send_data(void *arg);
void* recv_data(void *arg);
char* insert_(int cli_fd);
char* modify_(int cli_fd);
char* delete_(int cli_fd);
char* view_top3();
void view_top3_structure();
char* view_(int start, int page);
char* myorder_(int cli_fd, char *name_);
void view_structure(int page);
char* order_(int cli_fd, char *name_);

char name[NORMAL_SIZE]="[DEFALT]";     // name
char serv_time[NORMAL_SIZE];        // server time
char serv_port[NORMAL_SIZE];        // server port number
char clnt_ip[NORMAL_SIZE];            // client ip address
char msg[BUF_SIZE];
char snd_data[BUF_SIZE]; //서버에 보낼 데이터 버퍼

pthread_t thread; //클라이언트 thread
int count;
int page;
int main(int argc, char *argv[]){
    struct sockaddr_in server_addr; //서버 주소
    struct sockaddr_in client_addr; //클라이언트 주소
    int my_fd; 
    pthread_t snd_thread, rcv_thread;
    void* thread_return;

    /* user info */
    struct tm *t;
    time_t timer = time(NULL);
    t=localtime(&timer);
    sprintf(serv_time, "%d-%d-%d %d:%d:%d", t->tm_year+1900, t->tm_mon+1, t->tm_mday, t->tm_hour,
    t->tm_min, t->tm_sec);
    sprintf(name, "[%s]", argv[3]);
    sprintf(clnt_ip, "%s", argv[1]);
    sprintf(serv_port, "%s", argv[2]);

    /* create socket */
    if((my_fd = socket(AF_INET, SOCK_STREAM, 0)) < 0){
        perror("socket");
        exit(1);
    }

    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[2]));
    server_addr.sin_addr.s_addr = inet_addr(argv[1]);

    /* connect server */
    if(connect(my_fd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0){
        perror("connect");
        exit(1);
    }
    
    if(strcmp(name, "[admin]") == 0)
        menu_admin();
    else
        menu();
    
    pthread_create(&snd_thread, NULL,send_data ,(void*)&my_fd);
    pthread_create(&rcv_thread, NULL,recv_data ,(void*)&my_fd);
    pthread_join(snd_thread, &thread_return);
    pthread_join(rcv_thread, thread_return);

    close(my_fd);
    return 0;
}

void* send_data(void *arg){
    int sock = *((int*)arg);
    if(!strcmp(name, "[admin]")){
        process_admin(sock);
    }else{
        process(sock);
    }
    return NULL;
}

void* recv_data(void *arg){
    int sock = *((int*)arg);
    char rcv_data[BUF_SIZE];
    int len;
    
    while(1){
        len = recv(sock, rcv_data, BUF_SIZE-1, 0);
        if(len == -1)
            return (void*)-1;
        rcv_data[len]=0;
        if(strncmp(rcv_data,"[notice]",7)){ //notice 가 아닐 때
            view_(0,1);
        }
        fputs(rcv_data, stdout);
    }

    return NULL;
}

void process(int sock){
    count = 0;
    page = 1;
    char* member;
    char* name_ = name;
    view_structure(page);
    member = view_(sock, count);
    send(sock, member, strlen(member), 0);
    while(1){
        fgets(msg, BUF_SIZE, stdin);
        if(!strcmp(msg, "q\n") || !strcmp(msg, "Q\n")){
            close(sock);
            exit(0);
        }else if(!strcmp(msg, "1\n")){
            //주문 상품 보기
            view_structure(0);
            member = myorder_(sock, name_);
        }else if(!strcmp(msg, "m\n") || !strcmp(msg, "M\n")){
            //상품 보기 - 다음페이지
            count += ITEM_COUNT;
            page++;
            view_structure(page);
            member = view_(sock, count);
        }else if(!strcmp(msg, "n\n") || !strcmp(msg, "N\n")){
            // 상품보기 - 이전페이지
            count -= ITEM_COUNT;
            page--;
            if(count < 0){
                count = 0;
                page = 1;
            }
            view_structure(page);
            member = view_(sock, count);
        }
        else if(!strcmp(msg,"0\n")){
            //주문하기
            member = order_(sock, name_);
            continue;
        }
        send(sock, member, strlen(member), 0);
    }
}

void process_admin(int sock){
    char* admin;
    count = 0;
    page = 1;
    while(1){
        fgets(msg, BUF_SIZE, stdin);
        if(!strcmp(msg, "q\n") || !strcmp(msg, "Q\n")){
            close(sock);
            exit(0);
        }else if(!strcmp(msg, "0\n")){
            view_structure(page);
            admin = view_(sock, count);
        }
        else if(!strcmp(msg, "1\n")){
            printf("*****insert item*****\n");
            admin = insert_(sock);
        }else if(!strcmp(msg, "2\n")){
            printf("*****modify item*****\n");
            admin = modify_(sock);
        }else if(!strcmp(msg, "3\n")){
            printf("*****delete item*****\n");
            admin = delete_(sock);

        }else if(!strcmp(msg, "4\n")){
            printf("***view in order of sales***\n");
            view_top3_structure();
            admin = view_top3();
        }else if(!strcmp(msg, "n\n") || !strcmp(msg, "N\n")){
            // 상품보기 - 이전페이지
            count -= ITEM_COUNT;
            page--;
            if(count < 0){
                count = 0;
                page = 1;
            }
            view_structure(page);
            admin = view_(sock, count);
        }else if(!strcmp(msg, "m\n") || !strcmp(msg, "M\n")){
            //상품 보기 - 다음페이지
            count += ITEM_COUNT;
            page++;
            view_structure(page);
            admin = view_(sock, count);
        }
        else if(!strcmp(msg, "\n")){
            continue;
        }
        else{
        //notice
            sprintf(snd_data, "[notice] %s", msg); 
        }
        send(sock, admin, strlen(admin),0);
    }
}

void menu(){
    system("clear");
    printf("************* info *****************\n");
    printf(" server port : %s \n", serv_port);
    printf(" client IP   : %s \n", clnt_ip);
    printf(" name        : %s \n", name);
    printf(" server time : %s \n", serv_time);
    printf(" ************ shop menu ************\n");
    printf(" 0. want to order\n");
    printf(" 1. show my orders\n");
    printf(" **********************************\n");
    printf(" next page : m & M | previous page : n & N |");
    printf(" Exit -> q & Q\n\n");
}

void menu_admin(){
    system("clear");
    printf("************* info *****************\n");
    printf(" server port : %s \n", serv_port);
    printf(" client IP   : %s \n", clnt_ip);
    printf(" admin name   : %s \n", name);
    printf(" server time : %s \n", serv_time);
    printf(" ************ shop menu ************\n");
    printf(" 0. show items (next page : m & M | previous page : n & N)\n");
    printf(" 1. insert item\n");
    printf(" 2. modify item\n");
    printf(" 3. delete item\n");
    printf(" 4. view in order of sales\n");
    printf(" **********************************\n");
    printf(" Notify user when typing |");
    printf(" Exit -> q & Q\n\n");
}


char* insert_(int cli_fd){
    char name[NORMAL_SIZE];
    int price, stock_quantity, sales;
    printf("item name : ");
    scanf("%s", name);
    printf("item price : ");
    scanf("%d", &price);
    printf("item stockQuantity : ");
    scanf("%d", &stock_quantity);
    sales = 0;
    if(price < 0 || stock_quantity < 0){
        printf("please re-enter\n");
        return 0;
    }else{
        sprintf(snd_data, "[admin]INSERT INTO ITEM(name, price, stock_quantity, sales) VALUES ('%s', %d, %d, %d)\n",
            name, price, stock_quantity, sales);
        return snd_data;
    }
}

char* modify_(int cli_fd){
    char name[NORMAL_SIZE];
    int price, stock_quantity;
    printf("item name : ");
    scanf("%s", name);
    printf("modify item price : ");
    scanf("%d", &price);
    printf("modify item stockQuantity : ");
    scanf("%d", &stock_quantity);
    if(price < 0 || stock_quantity < 0){
        printf("please re-enter\n");
        return 0;
    }else{
        sprintf(snd_data, "[admin]UPDATE ITEM SET price = %d, stock_quantity = %d WHERE NAME = '%s'\n", price, stock_quantity, name);
        return snd_data;
    }

}
char* delete_(int cli_fd){
    char name[NORMAL_SIZE];
    printf("delete item name : ");
    scanf("%s", name);
    sprintf(snd_data, "[admin]DELETE FROM ITEM WHERE NAME = '%s'\n", name);
    return snd_data;
}
char* view_top3(int cli_fd){
    sprintf(snd_data,"[admin]SELECT name, sales, price FROM ITEM ORDER BY sales DESC LIMIT 3\n");
    return snd_data;
}
char* myorder_(int cli_fd, char *name_){
    char *origin = strtok(name_, "[]");
    sprintf(snd_data, "SELECT itemname, count, total_price FROM ORDERS WHERE name = '%s'\n", origin);
    return snd_data;
}
char* view_(int cli_fd, int start){
    sprintf(snd_data, "SELECT name, stock_quantity, price FROM ITEM LIMIT %d OFFSET %d\n", ITEM_COUNT, start);
    return snd_data;
}

char* order_(int cli_fd, char *name_){
    char item[NORMAL_SIZE];
    int stock_quantity;
    printf("item name : ");
    scanf("%s", item);
    printf("quantity : ");
    scanf("%d", &stock_quantity);
    sprintf(snd_data, "%s:%s:%d\n", name, item, stock_quantity);
    return snd_data;
}
void view_top3_structure(){
    printf("***TOP 3 ITEMS***\n");
    printf("-------------------------------\n");
    printf("|name \t| sales | total_price |\n");
    printf("-------------------------------\n");
}

void view_structure(int page){
    if(page > 0){
    printf("********ITEMS - %d********\n", page);
    }else{
        printf("******MY ORDER ITEMS******\n");
    }
    
    printf("-------------------------\n");
    printf("| name \t| amount | price |\n");
    printf("-------------------------\n");
}

