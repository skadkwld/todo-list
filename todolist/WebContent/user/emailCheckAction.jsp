<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="limuiju.todolist.dao.UserDao"%>
<%@ page import="limuiju.todolist.dao.UserDaoImpl"%>
<%@ page import="limuiju.todolist.util.SHA256"%>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
	String code = null;
	
	if(request.getParameter("code") != null){
		code = request.getParameter("code");
	}
	
	String userId = null;
	UserDao userDao = new UserDaoImpl();
	
	if(session.getAttribute("userId") != null){
		userId = (String)session.getAttribute("userId");
	}
	if(userId == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요')");
		script.println("location.href = 'login.jsp");
		script.println("</script>");
	}
	
	String userEmail = userDao.getUserEmail(userId);
	boolean isRight = (new SHA256().getSHA256(userEmail).equals(code)) ? true : false;
	if(isRight == true){
		userDao.setUserEmailChecked(userId);
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('인증에 성공했습니다.');");
		script.println("location.href = '../main.jsp;'");
		script.println("</script>");
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 코드입니다.');");
		script.println("location.href = '../main.jsp;'");
		script.println("</script>");
	}
%>