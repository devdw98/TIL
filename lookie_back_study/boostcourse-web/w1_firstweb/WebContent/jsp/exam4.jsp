<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp주석 입니다
여러줄로 사용 가능! --%>
<!-- HTML주석입니당 -->
<%
	for(int i=1;i<=5;i++){
		
		//java 주석 입니다
		/*
		여러줄도
		가능합니다
		*/


%>
<H<%=i %>>아름다운 한글 </H<%=i %>>
<%
}

%>
</body>
</html>