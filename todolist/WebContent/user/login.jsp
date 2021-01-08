<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/lib.jsp" %>
<div class="container">
	<div class="row">
		<div class="col">
			<div class="card bg-light p-1 text-center mb-4">
				<h3><a href="<%=request.getContextPath()%>" 
				class="text-decoration-none"><img src="/todolist/img/JustDoLogo.png" style="width:200px;height:100px"></a></h3>
			</div>
		</div>
	</div>
	<form method="post" action="userLoginAction.jsp">
		<div class="form-group">
			<label>아이디</label>
			<input type="text" name="userId" class="form-control">
		</div>
		<div class="form-group">
			<label>비밀번호</label>
			<input type="password" name="userPw" class="form-control">
		</div>
		<button type="submit" class="btn btn-primary">로그인</button>
	</form>
	<%@ include file='../include/footer.jsp' %>
</div>