## Servlet 이란?
URL 요청을 처리하는 프로그램  
링크 구성: http: // localhost:8080 /{프로젝트이름}/{URL Mapping값}

자바 웹 어플리케이션(Java Web Application)
- WAS에 설치(deploy)되어 동작하는 어플리케이션
- HTML, CSS, image, java class, 각종 설정 파일 등이 포함된다.

- 폴더 구조
    - WEB-INF 폴더: 
        - web.xml (배포기술자, WebApp의 정보들을 모두 가짐)
        - lib: jar files
        - classes 폴더: java package, classes, resources
    - 각종 폴더, 이미지, 다양한 리소스들

서블릿(Servlet)
- 자바 웹 어플리케이션의 구성요소 중 동적인 처리를 하는 프로그램의 역할
- 정의
    - WAS에서 동작하는 Java class
    - HttpServlet 클래스를 상속받아야 함
    - 웹 페이지 개발 시 JSP, Servlet을 조화롭게 사용해야 한다.
----
## Servlet 작성 방법
Servlet 3.x
- web.xml 파일이 필요하지 않다.
- Java annotation '@WebServlet("/url이름") 이 Servlet class 위에 존재해야 한다.

Servlet 2.5
- web.xml 파일이 꼭 필요하다.
- web.xml 에 servlet을 등록한 후 url mapping을 해야한다.

---
## Servlet Life Cycle
- 예시 : http://localhost.com/firstweb/LifeCycleServlet 
    1. 처음 실행 시
        1. 해당 URL로 클라이언트가 서버한테 요청 
        2. 서버는 'LifeCycleServlet' 이라는 URL 매핑은 'LifeCycleServlet' Servlet이라는 정보를 알아냄
        3. 해당 클래스가 메모리에 존재하는지 체크
            1. 메모리에 존재하지 않기 때문에 'LifeCycleServlet' 객체 생성하여 메모리에 올려줌
            - 생성자() - init() - service() 순으로 호출
    2. 새로고침 시
        - service() 만 호출
    3. Servlet 코드 수정 후 저장 + 브라우저 새로고침
        - 메모리에 올라가있었던 Servlet은 더이상 사용할 수 없게 된다.
            1. destroy() 호출
            2. 메모리에 해당 Servlet 존재하지 않음
            - 생성자() - init() - service() 순으로 호출
    4. WAS 종료
        - destroy() 호출
    
- 참고) 서버에 Servlet 객체를 하나만 생성한다.

<pre> <code>
// WAS는 Servlet 요청을 받으면 해당 Servlet이 메모리에 있는지 확인한다.
while(request요청){

    if(Servlet이 메모리에 없음){
    - 해당 Servlet class를 메모리에 올림 // 객체 생성 (생성자 코드 실행)
    - init() 실행
    }
    - service() 실행

    if(WAS 종료 || 웹 어플리케이션 갱신(ex-Servlet 코드의 수정)){
        - destroy() 실행
    }
    //WAS 종료 또는 웹 어플리케이션이 새롭게 갱신될 경우 destroy() 실행됨
}
</code></pre>

- service(request, response) 메소드
  - 템플릿 메소드 패턴으로 구현
      - request == GET ) doGet(request, response) 호출
      - request == Post ) doPost(request, response) 호출

----
## Request, Response 객체 이해하기
|웹 브라우저 |  | WAS | | 웹 어플리케이션|
|--|--|:--:|--|--|
| |-- 요청 -->| HttpServletRequest 생성|-- 요청 -->|서블릿|
| |<-- 응답 --| HttpServletResponse 생성|<-- 요청 --|     |

HttpServletRequest
- http protocol의 request 정보를 Servlet에게 전달하기위한 목적
- header, parameter, cookie, url, uri 등의 정보를 읽어 들이는 메소드를 가짐
- body의 Stream을 읽어들이는 메소드를 가짐

HttpServletResponse
- WAS는 어떤 클라이언트가 요청을 보냈는지 알고있음
- 해당 클라이언트에게 응답을 보내기 위해 이 객체를 생성 + Servlet에게 전달
- Servlet은 이 객체를 이용하여 content type, 응답 코드, 응답 메세지 등을 전송

