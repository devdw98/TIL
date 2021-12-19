<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Modify Page</div>

			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
					<div class="form-group">
						<label>bno</label> <input class="form-control" name='bno'
							value='<c:out value="${board.bno }"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name='title'
							value='<c:out value="${board.title}"/>'>
					</div>
					<div class="form-group">
						<label>Text Area</label>
						<textarea class="form-control" rows="3" name='content'>
						<c:out value="${board.content}" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name='writer'
							value='<c:out value="${board.writer }"/>'>
					</div>
					<div class="form-group">
						<label>RegDate</label> <input class="form-control" name='regDate'
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate }"/>'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label>UpdateDate</label> <input class="form-control"
							name='updatedate'
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updatedate }"/>'
							readonly="readonly">
					</div>
					<button type="submit" data-oper='modify' class="btn btn-default"
						onclick="location.href='/board/modify?bno=<c:out value="${board.bno }"/>'">Modify</button>

					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info"
						onclick="location.href='/board/list'">List</button>
				</form>
			</div>

		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");
		$('button').on("click", function(e) {
			e.preventDefault();
			var operation = $(this).data("oper");
			console.log(operation);
			if (operation === 'remove') {
				formObj.attr("action", "/board/remove");
			} else if (operation === 'list') {
				//move to list
			//	self.location = "/board/list";
				formObj.attr("action",".board/list").attr("method","get");
				formObj.empty(); //list로 이동 시 보낼 파라미터가 없기 때문에
				return;
			}
			formObj.submit();
		});
	});
</script>

<%@ include file="../includes/footer.jsp"%>