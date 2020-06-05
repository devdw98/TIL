<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dw.study.lookie.pr_todo.dto.TodoDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=path%>/main.css"/>
</head>
<body>
<script type="text/javascript" src="todocode.js"/>
<div id="header">
  <h1 id = "ex_title">TODO LIST</h1>
  <button id="new-button" type="button" onClick="location.href='/pr_todo/todoForm'">새로운 TODO 등록</button>
</div>
<div class="nav-list" id="todo-list">
  <table>
    <tr>
    <th>TODO</th>
    </tr>
<%
	List <TodoDto> todos = (List<TodoDto>)request.getAttribute("todo");
	for(TodoDto dto : todos){
		Long id = dto.getId();
%>
<tr>
	<td>
	<h3><%= dto.getTitle() %></h3>
	등록날짜:<%= dto.getRegDate() %>, <%= dto.getName() %>, 우선순위 <%=dto.getSequence() %>
	<button id="todo-button" onClick="changeType(id);">-></button>
	</td>
</tr>
<%
	}
%>
  </table>
</div>

<div class="nav-list" id="doing-list">
  <table>
    <tr>
    <th>DOING</th>
    </tr>
<%
	List <TodoDto> doings = (List<TodoDto>)request.getAttribute("doing");
	for(TodoDto dto : doings){
%>
<tr>
	<td>
	<h3><%= dto.getTitle() %></h3>
	등록날짜:<%= dto.getRegDate() %>, <%= dto.getName() %>, 우선순위 <%=dto.getSequence() %>
	<button id="doing-button" onClick="changeType();">-></button>
	</td>
</tr>
<%
	}
%>
  </table>
</div>

<div class="nav-list" id="done-list">
  <table>
    <tr>
    <th>DONE</th>
    </tr>
<%
	List <TodoDto> dones = (List<TodoDto>)request.getAttribute("done");
	for(TodoDto dto : dones){
%>
<tr>
	<td>
	<h3><%= dto.getTitle() %></h3>
	등록날짜:<%= dto.getRegDate() %>, <%= dto.getName() %>, 우선순위 <%=dto.getSequence() %>
	</td>
</tr>
<%
	}
%>
  </table>
</div>

</body>
</html>