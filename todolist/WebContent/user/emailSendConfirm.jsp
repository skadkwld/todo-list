<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="limuiju.todolist.dao.UserDao" %>
<%@ page import="limuiju.todolist.dao.UserDaoImpl" %>

<%
	String userId = null;
	if(session.getAttribute("userId") != null){
		userId = (String) session.getAttribute("userId");
	}
	if(userId == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요 .');");
		script.println("location.href = 'login.jsp';");
		script.println("</script>");
		script.close();
		return;
	}
%>
<div class="container">
	<%@ include file='../include/head.jsp' %>
	<section class="mt-3" style="max-width : 560px;">
		<div class="alert alert-waring mt-4" role="alert">
			이메일 주소 인증을 하셔야 이용 가능합니다.
		</div>
		<a href="emailSendAction.jsp" class="btn btn-primary">인증 메일 다시 받기</a>
	</section>
	<%@ include file="../include/footer.jsp" %>
</div>
