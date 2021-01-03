<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/lib.jsp" %>
<%
	pageContext.setAttribute("todo",request.getAttribute("todo"));
%>
<div class="container">
	<form action="fixTodo" method="post">
		<div class="row form-group">
			<label for="title">Title : </label>&nbsp;
			<input type="text" id="title"  
				name="title" value="${todo.title}"/>
		</div>
		<div class="row form-group">
			<label for="todoDate">Date : </label>&nbsp;
			<input type="date" id="todoDate" name="todoDate" value="${todo.todoDate}"/>
		</div>
		<div class="row">
			<a href="listTodo" class="btn btn-outline-secondary">목록</a>
			<button type="submit" class="btn btn-outline-primary">수정</button>
			<button type="button" class="btn btn-outline-danger"
				data-toggle="modal" data-target="#delModal">삭제</button>
		</div>
		<input type="hidden" name="todoNum" value="${todo.todoNum}"/>
	</form>
</div>

<div id="delModal" class="modal fade" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">할일 삭제</h5>
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>할일을 삭제하겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<a href="delTodo?todoNum=${todo.todoNum}" class="btn btn-primary">확인</a>
			</div>
		</div>
	</div>
</div>