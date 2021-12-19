<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try { //내장객체를 가지고잇어서 application 객체를 선언하지 않아도 됨
			int value = (int) application.getAttribute("value");
			value = value + 2;
			application.setAttribute("value", value);
	%>
	<h1><%=value%></h1>
	<%
		} catch (NullPointerException e) {
	%>
	<h1>value 값이 존재하지 않음</h1>
	<%
		}
	%>

</body>
</html>