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
	String userPw = null;
	
	if(request.getParameter("userId") != null){
		userId = request.getParameter("userId");
	}
	if(request.getParameter("userPw") != null){
		userPw = request.getParameter("userPw");
	}
	if(userId == null || userPw == null){
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
	int result = userDao.login(userId, userPw);
	
	PrintWriter script = response.getWriter();
	if(result == 1){
		session.setAttribute("userId", userId);
		script.println("<script>");
		script.println("location.href = '../main.jsp'");
		script.println("</script>");
		script.close();
		return;
	}else if(result == 2){
		script.println("<script>");
		script.println("alert('비밀번호가 틀렸습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}  else if(result == -1){
		script.println("<script>");
		script.println("alert('로그인에 실패하였습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
%>