<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='msg.jsp' %>

<div class="row">
	<div class="col">
		<div class="card bg-light p-1 text-center mb-4">
			<h3><a href="<%=request.getContextPath()%>" 
			class="text-decoration-none"><img src="/todolist/img/JustDoLogo.png" style="width:200px;height:100px"></a></h3>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-4">
		<nav>
			<div class="nav nav-tabs nav-pills">
				<a class="nav-link" tabindex="-1"
					href="/todolist/todo">&nbsp;Todo&nbsp;</a>
				<a class="nav-link" tabindex="-1"
					href="/todolist/">&nbsp;Done&nbsp;</a>
			</div>
		</nav>
	</div>
	
	<div class="col-8">
		<c:if test="${!empty requestScope.msgId }">
			<div class='mb-1 pl-4 p-0 alert alert-dismissible fade show justify-content-end
					${requestScope.msgId.endsWith("1") ? "alert-success" : "alert-danger"}'>
				<p class="m-0">
					${msg}
				</p>
				<button type="button" class="p-0 close" data-dissmiss="alert" tabindex="-1">
					<span>&times;</span>
				</button>	
			</div>		
		</c:if>
	</div>
</div>