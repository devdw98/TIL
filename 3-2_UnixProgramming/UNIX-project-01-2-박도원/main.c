#include <stdio.h> //perror(3), printf(3), fopen(3)
#include <stdlib.h> //exit(3)
#include <unistd.h> //getopt 관련, chdir(2), getcwd(3)
 //디렉터리, 파일 관련 라이브러리  
#include <dirent.h> //opendir(3), closedir(3), readdir(3)
#include <sys/types.h> //opendir(3), closedir(3), mkdir(2), chmod(2)
#include <sys/stat.h> //mkdir(2), chmod(2)
#include <fcntl.h> //rename(2)
//문자열 관련 라이브러리
#include <string.h> //strcmp(3)
#include <time.h>

extern char *optarg;
extern int optind;

typedef struct schedule{
    char *time;
    char *content;
}SCHEDULE;

#define BUFSIZE 256

void goDirForInsert(char *dir);
int goDir(char *dir);
void printSchedules(char *filename);
void insertSchedule(char *filename, char *time, char *content);
char *format(SCHEDULE s);
void deleteSchedule(char *filename, char *time);
void printSchedule(char *filename);

void view(char *dir, char *day, int option);
void viewOthersDay(char *arr[]);
void insertToday(char *arr[], char *dir, char *filename);
void deleteToday(char *arr[], char *dir, char *filename);
void insertOthersDay(char *arr[]);
void deleteOthersDay(char *arr[]);

int main(int argc, char *argv[])
{
    //시간 관련
    struct tm *tm;
    time_t t;
    
    char *year = "20";
    char dir[BUFSIZE];
    char day[BUFSIZE];
    // char t[BUF_SIZE];
    char* output[] = { //날짜 포멧
        "%G-%m", //2020-11
        "%g%m%d", //201104
        "%H:%M" //23:40
    };

    time(&t); //UTC 이후의 시간 반환
    tm = localtime(&t);
    strftime(dir,BUFSIZE,output[0],tm); //현재 기준 저장할 디렉토리 이름
    strftime(day,BUFSIZE,output[1],tm); //현재 기준 저장할 파일 이름

    int c, found = 0;
    while((c = getopt(argc, argv, "ynts:i:m:d:I:M:D:"))!= -1) //옵션 확인
    {
        found = 1; //옵션 찾음
        switch(c)
        {
            // case 'a' : 
            //      //등록된 스케줄 중 10개 보여주기, 특정 키 누를 때마다 다음 10개로 넘어감
            //     break;
            case 'y': // y(yesterday)전 날 등록된 스케줄 보기
            case 'n': // n(now) 오늘 등록된 스케줄 보기
            case 't': // t(tomorrow)다음날 등록된 스케줄 보기
                view(dir, day, c);
                break;
            case 's':
                viewOthersDay(argv);
                break;
            case 'i' : // i(insert) 오늘 스케줄 등록
            case 'm' : // m(modify) 오늘 스케줄 수정
                insertToday(argv, dir, day);
                break;
            case 'd' : // d(delete) 오늘 스케줄 삭제
                deleteToday(argv, dir, day);
                break;
            case 'I' : // I(Insert) 특정한 날 스케줄 등록
            case 'M' : // M(Modify) 특정한 날 스케줄 수정
                insertOthersDay(argv);
                break;
            case 'D': //D(Delete) 특정한 날 스케줄 삭제
                deleteOthersDay(argv);
                break;
            default:
                printf("This option is not registered. Please run ./main to see the possible options.\n");
                break;
        }
    }
    if(found != 1) {//옵션 없을 때
        //전체 옵션 설명 출력
        printf("                            /* OPTIONS */\n");
        printf(" -y : View Yesterday's Schedules  | ./main -y (no argument)\n");
        printf(" -n : View Today's Schedules      | ./main -n (no arguments)\n");
        printf(" -t : View Tomorrow's Schedules   | ./main -t (no arguments)\n");
        printf(" -s : View Other's Day Schedules  | ./main -s 201105 (day)\n");
        printf(" -i : Insert Today's Schedule     | ./main -i 18:00 lunch (time content)\n");
        printf(" -m : Modify Today's Schedule     | ./main -m 18:00 lunch (time content)\n");
        printf(" -d : Delete Today's Schedule     | ./main -d 18:00 (time)\n");
        printf(" -I : Insert Other's Day Schedule | ./main -I 201105 18:00 date (day time content)\n");
        printf(" -M : Modify Other's Day Schedule | ./main -M 201105 18:00 date (day time content)\n");
        printf(" -D : Delete Other's Day Schedule | ./main -D 201105 18:00 (day time)\n");
    }
    return 0;
}

void goDirForInsert(char *dir){
    char buf[BUFSIZE];
    //dir 디렉토리가 존재하지 않으면
    if((opendir(dir)) == NULL){ 
        //디렉토리를 생성한다.
        if(mkdir(dir, 0755) == -1){ 
            //디렉토리 생성 실패하면
            perror("mkdir error"); 
            exit(1);
        }
    }
    chdir(dir); //해당 디렉토리에 들어간다.
}

int goDir(char *dir){
    char buf[BUFSIZE];
    //dir 디렉토리가 존재하지 않으면
    if(opendir(dir) == NULL){
        //해당 월에 등록된 일정이 없다고 출력 후 종료
        printf("There is no registered schedule for that month.\n");
        return 0; // 디렉토리 없음
    }else{
        chdir(dir); //해당 디렉토리에 들어간다..
        return 1; // 디렉토리 찾음
    }
}

void printSchedules(char *filename){
    FILE *fp ;
    //filename 파일이 존재하지 않으면
    if((fp= fopen(filename, "r")) == NULL){ 
        //해당 일자에 등록된 일정이 없다고 출력 후 종료
        printf("There is no registered schedule.\n");
        exit(1);
    }else{
        char buf[BUFSIZE];
        //해당 일자에 등록된 일정을 보여준다.
        while(fgets(buf, BUFSIZE, fp)!=NULL){
            // puts(buf);
            printf("%s", buf);
        }
    }
}

//배열 저장 후 같은 시간 존재하면 문자열 변경하기 + 시간 순으로 정렬
void insertSchedule(char *filename, char *time, char *content){
    FILE *fp; //파일
    int length = 0; //등록되어있는 일정 개수
    char buf[BUFSIZE];
    char *tmp;
    int found = 1;
    int finish = 0; //등록되었는지 확인

    if((fp= fopen(filename, "a+")) == NULL){ 
        //파일이 없는 경우(생성도 안되는 경우) 에러 출력 후 종료
        perror("can't found file");
        exit(1);
    }
    //파일 안 라인 수 구하기
    while(fgets(buf, BUFSIZE, fp) != NULL){ 
        length++;
    }
    //새로운 일정 데이터 생성
    SCHEDULE new;
    new.time = time;
    new.content = content;
    //filename에 등록된 일정이 없는 경우
    if(length == 0){
        tmp = format(new);
        fputs(tmp, fp);
        free(tmp);
        fclose(fp);
        finish++;
    }
    else{ // filename에 일정이 있는 경우
        rewind(fp);//파일 위치를 처음으로 돌려놓음
        SCHEDULE schedules[length]; //등록된 일정만큼의 배열 생성
        int i = 0;
        int same = 0; //같은 시간이 있는지 판별
        //파일에서 시간별 일정 읽어와서 시간, 내용 배열 저장
        while(fgets(buf, BUFSIZE, fp) != NULL){
            buf[strlen(buf)-1]='\0'; //개행문자 제거
            //시간 저장
            tmp = strtok(buf, "|");
            char *ptr1 = (char*)malloc(sizeof(char)*(strlen(tmp)));
            strcpy(ptr1, tmp);
            schedules[i].time = ptr1;
            //내용 저장
            tmp = strtok(NULL, "|");
            char *ptr2 = (char*)malloc(sizeof(char)*(strlen(tmp)));
            strcpy(ptr2, tmp);
            schedules[i].content = ptr2;

            i++;
        }
        fclose(fp); //파일 닫기

        /*
        time이 이미 일정에 등록되어있는지 확인 
        */
       for(i = 0; i < length; i++){
           //time에 이미 일정이 등록되어있음
           if(strcmp(time, schedules[i].time) == 0){
               same++;
               //content도 같은 경우
               if(strcmp(content, schedules[i].content) == 0){
                   //내용 바뀌는 것 없으므로 종료
                   printf("The same content is already registered at the same time.\n");
                   exit(0); 
                   break;
               }else{ //content는 다른 경우
                /* 
                해당 시간에 다른 스케줄이 있는 경우
                - option i : 일정 내용 추가
                - option m : 기존 일정 내용 삭제 후 추가 (수정)
                */
                    printf("The schedule is already registered. Do you want to add or modify content? \n");
                    printf("Current content : %s\n", schedules[i].content);
                    printf("* option i - %s, %s\n", schedules[i].content, content);
                    printf("* option m - %s\n", content);
                    printf("* others - exit\n");
                    //옵션 선택
                    printf("Select an option : ");
                    char option;
                    scanf("%c", &option);
                    switch(option){
                        case 'i': //일정 내용 추가
                            strcat(schedules[i].content,", ");
                            strcat(schedules[i].content, content);
                            break;
                        case 'm': //기존 일정 삭제 후 추가
                            strcpy(schedules[i].content, content);
                            break;
                        default:
                            break;
                    }
               }
            }
       }

       fp = fopen(filename,"w");
       //time이 이미 일정에 등록되어있는 경우
       if(same > 0){
           for(i = 0; i < length; i++){
                tmp = format(schedules[i]);
                fputs(tmp, fp);
                free(tmp);
            }
            finish++;
       }else{ //time에 일정이 없는 경우 시간별 내림차순으로 저장
            int found = 0;
            for(i = 0; i < length; i++){
               if(strcmp(time, schedules[i].time) < 0){
                    found++;
                    tmp = format(new);
                    fputs(tmp, fp);
                    free(tmp);
                    break;
               }else{
                   tmp = format(schedules[i]);
                   fputs(tmp, fp);
                   free(tmp);
               }
           }
           for(i; i < length; i++){
                tmp = format(schedules[i]);
                fputs(tmp, fp);
                free(tmp);
           }
           if(found == 0){
                tmp = format(new);
                fputs(tmp, fp);
                free(tmp);
           }
           finish++;
       }
        fclose(fp);
    }
    if(finish > 0){
        printf("Successfully registered!\n");
    }else{
        printf("Registration failed.\n");
    }
}

char *format(SCHEDULE s){
    char *result = (char*)malloc(sizeof(char)*(sizeof(s.time)+sizeof(s.content)));
    strcpy(result, s.time);
    strcat(result, "|");
    strcat(result, s.content);
    strcat(result,"\n");
    return result;
}

void deleteSchedule(char *filename, char *time){
    FILE *tf; //임시파일
    FILE *origin; //기존파일
    int found = 0; //time 일정이 존재하는지 판단
    struct stat info; //파일의 정보 검색 - 사이즈
    char buf[BUFSIZE];
    char buf2[BUFSIZE];
    
    char *temp;
    char *tfname = "temp";
    //filename 파일 열기
    if((origin = fopen(filename, "r")) == NULL){ //filename 파일이 존재하지 않으면
        //해당 일자에 등록된 일정이 없다고 출력 후 종료
        perror("There is no registered schedule for that date");
        exit(1);
    }
    //임시파일을 생성
    if((tf = fopen(tfname,"w")) == NULL){ //임시파일 생성 못하면
        //에러 발생시키고 종료
        perror("can't open temp file");
        exit(1);
    }
    //기존파일을 한 줄씩 읽어가며 임시파일에 저장.
    //time 일정이 존재하면 해당 일정은 임시파일에 저장하지 않는다.
    while(fgets(buf, 256, origin) != NULL){
        strcpy(buf2, buf);
        temp = strtok(buf, "|");
        if(strcmp(time, temp) == 0){
            //time 일정이 존재하면 해당 일정은 임시파일에 저장하지 않고 넘어감
            found++; //time 일정이 존재함을 표시
            continue;
        }else {
            //기존파일의 일정들을 임시파일에 저장
            fputs(buf2, tf);
        }
    }
    //임시파일, 기존파일 닫기
    fclose(tf);
    fclose(origin);

    //임시파일 정보 받기
    stat(tfname, &info);

    //해당 시간에 일정이 없는 경우
    if(found == 0){
        printf("There is no registered schedule at that time.\n");
        //임시파일 삭제
        remove(tfname);
        exit(1);
    }
    //임시파일의 용량이 0이면 기존파일과 임시파일 모두 삭제
    if(info.st_size == 0){
        remove(tfname);
        remove(filename);
        printf("Cleared all schedules for that date.\n");
        exit(1);
    }
    //임시파일을 기존파일로 바꿔주기
    rename(tfname, filename);
    printf("Successfully deleted schedule!\n");
}


void view(char *dir, char *day, int option){
    goDir(dir);
    switch(option){
        case 'y':
            day[strlen(day)-1] -= 1;
            printf("YESTERDAY : %s\n---------------\n", day);
            break;
        case 'n':
            printf("TODAY : %s\n---------------\n", day);
            break;
        case 't':
            day[strlen(day)-1] += 1;
            printf("TOMORROW : %s\n---------------\n", day);
            break;
        default:
            printf("TODAY : %s\n---------------\n", day);
            break;
    }
    printSchedules(day);
}
void viewOthersDay(char *arr[]){
    char *tmp = arr[optind-1];
    char dir[10] = "2020-11";
    int i = 0;
    while(i < 5){
        switch(i){
            case 0:
            case 1:
                dir[i+2] = tmp[i];
                i++;
                continue;
            case 2:
                dir[i+2] = '-';
                i++;
                // continue;
            case 3:
            case 4:
                dir[i+2] = tmp[i-1];
                i++;
            // break;
        }
    }
    if(goDir(dir) == 1){
        printf("DAY : %s\n---------------\n", tmp);
        printSchedules(tmp);
    }
}

void insertOthersDay(char *arr[]){
    char *tmp = arr[optind-1];
    char dir[10] = "20";
    int i = 0;
    while(i < 5){
        switch(i){
            case 0:
            case 1:
                dir[i+2] = tmp[i];
                i++;
                continue;
            case 2:
                dir[i+2] = '-';
                i++;
                // continue;
            case 3:
            case 4:
                dir[i+2] = tmp[i-1];
                i++;
            // break;
        }
    }
    // printf("%s\n", dir);
    // char *dir = makeDirName(arr[optind-1]);
    goDir(dir);
    insertSchedule(arr[optind-1], arr[optind], arr[optind+1]);
}
void insertToday(char *arr[], char *dir, char *filename){
    goDirForInsert(dir);
    insertSchedule(filename, arr[optind-1],arr[optind]);
}

void deleteToday(char *arr[], char *dir, char *filename){
    goDir(dir);
    deleteSchedule(filename, arr[optind-1]);
}

void deleteOthersDay(char *arr[]){
    char *tmp = arr[optind-1];
    char dir[10] = "20";
    int i = 0;
    while(i < 5){
        switch(i){
            case 0:
            case 1:
                dir[i+2] = tmp[i];
                i++;
                continue;
            case 2:
                dir[i+2] = '-';
                i++;
                // continue;
            case 3:
            case 4:
                dir[i+2] = tmp[i-1];
                i++;
            // break;
        }
    }
    if(goDir(dir) == 1)
        deleteSchedule(arr[optind-1], arr[optind]);
}
