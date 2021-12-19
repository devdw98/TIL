<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 내장객체를 어떻게 사용하는 지! -->
<!-- JSP는 servlet으로 바껴서 실행이 된다!! -->

<%
    StringBuffer url = request.getRequestURL();

    out.print("url: "+ url.toString());
    out.print("<br>");
%>

</body>
</html>