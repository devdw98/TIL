<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>할 일 등록</h1>
	<form action="/pr_todo/todoForm" method="post">
		어떤일인가요?<br>
		<input type="text" name="title" maxlength="24"> <br>
		누가 할 일인가요?<br>
		<input type="text" name="name"> <br>
		우선순위<br>
		<input type="radio" name="sequence" value="1">1순위
		<input type="radio" name="sequence" value="2">2순위
		<input type="radio" name="sequence" value="3">3순위
		<br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>