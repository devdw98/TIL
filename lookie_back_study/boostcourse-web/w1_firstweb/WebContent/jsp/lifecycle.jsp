<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	HELLO

	<%
	System.out.print("jspService()");
%>
	<%!public void jspInit() {
		System.out.print("jspInit()");
	}%>
	<!-- 메서드 , 필드 정의 -->
	<%!public void jspDestroy() {
		System.out.print("jspDestroy( )");
	}%>

</body>
</html>