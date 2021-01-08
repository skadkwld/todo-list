<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="limuiju.todolist.domain.User"%>
<%@ page import="limuiju.todolist.dao.UserDao"%>
<%@ page import="limuiju.todolist.dao.UserDaoImpl"%>
<%@ page import="limuiju.todolist.util.SHA256"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userId = null;
	
	if(session.getAttribute("userId") != null){
		userId = (String)session.getAttribute("userId");
	}
	if(userId != null){
		PrintWriter script = response.getWriter();
		script.println("<sctipt>");
		script.println("alert('로그인이 된 상태입니다.');");
		script.println("location.href = '../main.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	String userPw = null;
	String userEmail = null;
	
	if(request.getParameter("userId") != null){
		userId = request.getParameter("userId");
	}
	if(request.getParameter("userPw") != null){
		userPw = request.getParameter("userPw");
	}
	if(request.getParameter("userEmail") != null){
		userEmail = request.getParameter("userEmail");
		PrintWriter script = response.getWriter();
	}
	if(userId == null || userPw == null || userEmail == null){
%>
		<script>
			alert("입력이 안 된 사항이 있습니다.");
			history.back();
			script.close();
		</script>
<%
		return;
	}
	UserDao userDao = new UserDaoImpl();
	int result = userDao.join(
			new User(userId, userPw, userEmail,SHA256.getSHA256(userEmail),"false"));
	
	if(result > 0){
		PrintWriter script = response.getWriter();
		session.setAttribute("userId", userId);
		
		script.println("<script>");
		script.println("location.href = 'emailSendAction.jsp'");
		script.println("</script>");
	} else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('같은 아이디의 회원이 있습니다.');");
		script.println("</script>");
	}
%>