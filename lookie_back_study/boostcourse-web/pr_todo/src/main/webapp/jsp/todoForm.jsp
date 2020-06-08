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
	<form action="/pr_todo/todoForm" method="post" name="AddTodo">
		<div class="form-group">
			<label for="form-title">어떤일인가요?</label><br>
			<input type="text" class="form-group" name="title" id="form-title" placeholder="24자까지 입력 가능" maxlength="24" required><br>
		</div>
		<div class="form-group">
			<label for="form-title">누가 할 일인가요?</label><br>
			<input type="text" class="form-group" name="name" id="form-author" placeholder="홍길동" required><br>
		</div>
		<div class="form-group">
			<label for="form-title">우선순위</label><br>
			<input type="radio" name="sequence" value="1">1순위
			<input type="radio" name="sequence" value="2">2순위
			<input type="radio" name="sequence" value="3">3순위
		</div>
		<br>
		<button type="button" onClick="location.href='/pr_todo/Main'">이전으로</button>
		<input type="submit" value="제출">
		<input type="reset" value="내용지우기">
	</form>

</body>
</html>