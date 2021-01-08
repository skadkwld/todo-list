<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='msg.jsp' %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="limuiju.todolist.dao.UserDao" %>
<%@ page import="limuiju.todolist.dao.UserDaoImpl" %>

<%
	String userId = null;
	if(session.getAttribute("userId") != null){
		userId = (String)session.getAttribute("userId");
	} 
	if(userId == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요.')");
		script.println("location.href = 'user/login.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	String emailChecked = new UserDaoImpl().getUserEmailChecked(userId);
	if(emailChecked == "false"){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'user/emailSendConfirm.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
%>

<div class="row">
	<div class="col">
		<div class="card bg-light p-1 text-center mb-4">
			<h3><a href="/todolist" 
			class="text-decoration-none"><img src="/todolist/img/JustDoLogo.png" style="width:200px;height:100px"></a></h3>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-8"></div>
	<div class="col-4">
		<nav class="justify-content-end">
			<ul style="list-style:none;" class="justify-content-end">
<%
			if(userId == null) {
%>
				<li style="float:left;" class="mr-2">
					<a href="/todolist/user/login.jsp">로그인</a>
				</li>
				<li style="float:left;" class="mr-2">
					<a href="/todolist/user/userJoin.jsp">회원가입</a>
				</li>
<%
			} else {
%>
				<li style="float:left;" class="mr-2">
					<a href="/todolist/user/userLogout.jsp">로그아웃</a>
				</li>
<%
			}
%>
			</ul>
		</nav>
	</div>
</div>
<div class="row">
	<div class="col-4">
		<nav>
			<div class="nav nav-tabs nav-pills">
				<a class="nav-link ${requestScope.job==1 ? 'active' : '' }" tabindex="-1"
					href="/todolist/todo">&nbsp;Todo&nbsp;</a>
				<a class="nav-link ${requestScope.job==2 ? 'active' : '' }" tabindex="-1"
					href="/todolist/done">&nbsp;Done&nbsp;</a>
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