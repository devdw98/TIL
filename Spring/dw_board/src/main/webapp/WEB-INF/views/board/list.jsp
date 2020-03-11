<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>


<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Tables</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
	<div class="panel-heading">Board List Page
	<button id='regBtn' type="button" class="btn btn-xs pull-right">Register New Board</button></div>
	<!-- 	<h6 class="m-0 font-weight-bold text-primary">Board List Page</h6>-->
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>수정일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}" /></td>
							<td><c:out value="${board.title }" /></td>
							<td><c:out value="${board.writer }" /></td>
							<td><c:out value="${board.regdate }" /></td>
							<td><c:out value="${board.updatedate }" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModelLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리 완료</div>
						<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
							<button type="button" class="btn btn-primary">save
								changes</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>'; //생성된 게시글의 번호
		
		checkModal(result);
		
		function checkModal(result){
			if(result===''){
				return
			}
			if(parseInt(result)>0){
				$(".modal-body").html("게시글 "+parseInt(result)+" 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		
		$("#regBtn").on("click",function(){
			self.location="/board/register";
		});
	});
</script>


<%@ include file="../includes/footer.jsp"%>