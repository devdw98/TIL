# 코어 태그 

######  <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>

1. #### 변수 지원

- `set` : JSP에서 사용할 변수 설정

  - <c:set var="변수명" value="값" [scope="영역"] />  or <c:set var="변수명" [scope="영역"]>값</c:set >

    var: 값을 저장할 EL의 변수 이름 지정

    value : 변수의 값 지정

    scope : 변수를 저장할 영역 ( page[default] , request, session, application )

  - <c:set target="대상" property="이름" value="값"/> 

    or <c:set target="대상" property="프로퍼티이름">값</c:set >

    target: 프로퍼티 값을 설정할 대상 객체(자바빈 객체, Map) 지정

    property: 설정할 프로퍼티의 이름 지정

    - javaBin : 
    - Map : 

    value: 프로퍼티의 값 지정

- `remove` : 설정한 변수 제거

  - <c:set var="변수이름" scope="영역" />

    

2. #### 흐름 제어

- `if` : 조건에 따라 내부 코드 실행

  - <c:if test="조건">

    ... 

    </ c:if>

    - test 속성(조건 자리)
      1. true : 항상 true . 몸체 내용 실행
      2. some_txt : 항상 false. 몸체 내용 실행 안함
      3. ${expr}: EL의 결과값이 true인 경우 몸체 내용 실행
      4. <%= expr %>: 표현식의 결과값이 true인 경우 몸체 내용 실행

- `choose` : 다중 조건 처리 (+ when, otherwise)

  when : if 문과 else if 문 표현

  otherwise : 위의 when 태그가 모두 실행되지 않으면 실행됨(필요한 경우에만 추가)

  - <c:choose >

    ​	<c:when test = "${~~}">

    ​		...

    ​	</ c:when>

    ​	<c:when test = "${~~}">

    ​		...

    ​	</c:when >

    ​	(여러 개의 when 사용 가능)

    ​	<c:otherwise >

    ​		when 태그의 test값이 모두 false면 실행

    ​	</c:otherwise >

    </c:choose >

    

- `forEach` : 컬렉션, Map의 각 항목을 순차적으로 처리 시 사용 (for, do-while 가능) //추후 작성

  - <c:forEach var="변수" items="아이템" [여러 속성들 올 수 있음 ex) begin, end, step] >

    ${변수} 사용

    ...

    </c:forEach >

    

- `forTokens` : 구분자로 분리된 각각의 토큰 처리 시 사용 (java.util.StringTokenizer 클래스와 같은 기능)

  - <c:forTokens var="tokens" items="문자열" delims="구분자">

    ​	${token}의 사용

    </c:forTokens >

    items: String 값

    delims: 나눌 토큰

  

3. #### URL 처리

- `import` : URL 사용하여 다른 자원의 결과를 삽입

- `redirect` : 지정한 경로(페이지)로 리다이렉트

  - <c:redirect url="URL" [context="컨텍스트경로"]>

    ​	<c:param name="이름" value="값" />

    </c:redirect >	

  - ###### <c:redirect > 태그 실행 시 그 이후의 코드는 실행되지 않음

- `url` : url 재작성

  - <c:url value="URL" [context="varName"] [scope="영역"]>

    ​	<c:param name="이름" value="값" />

    </c:url >

    value : 절대 URL과 상대 URL 

    

4. #### 기타

- `catch` : 발생된 익셉션을 EL변수에 저장할 때 사용

  - <c:catch var="exName">

    ​	익셉션 발생할 수 있는 코드

    </c:catch >

    ${exName}

- `out` : JspWriter 에 내용 출력

  - <c:out value="value" [escapeXml="(true|false)"] [default="기본값"] />

    or <c:out value="value" [escapeXml="(true|false)"]> [default="기본값"] </c:out >

    value: JspWriter에 출력할 값 지정 (String)

    escapeXml: true 시 문자 변경됨. 기본값 true

    default: value 속성에서 지정한 값이 존재하지 않을 때 사용될 값 지정