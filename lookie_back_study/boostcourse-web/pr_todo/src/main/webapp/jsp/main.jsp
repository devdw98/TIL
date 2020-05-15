<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button type="button" onClick="location.href='/pr_todo/todoForm'" >새로운 TODO 등록</button>

<c:forEach var="todo" items="${requestScope.todolist }">
${ todo}<br>
</c:forEach>




</body>
</html>