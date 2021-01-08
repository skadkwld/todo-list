<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Properties" %>
<%@ page import="javax.mail.Transport"%>
<%@ page import="javax.mail.Message"%>
<%@ page import="javax.mail.Address"%>
<%@ page import="javax.mail.internet.InternetAddress"%>
<%@ page import="javax.mail.internet.MimeMessage"%>
<%@ page import="javax.mail.Session"%>
<%@ page import="javax.mail.Authenticator"%>
<%@ page import="limuiju.todolist.dao.UserDao"%>
<%@ page import="limuiju.todolist.dao.UserDaoImpl"%>
<%@ page import="limuiju.todolist.util.SHA256"%>
<%@ page import="limuiju.todolist.util.Gmail"%>
<%@ page import="java.io.PrintWriter"%>
<%
	UserDao userDao = new UserDaoImpl();
	String userId = null;
	
	if(session.getAttribute("userId") != null){
		userId = (String)session.getAttribute("userId");
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println(userId);
		script.println("</script>");
	}
	
	if(session.getAttribute("userId") == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요');");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
		return;
	}

	String emailChecked = userDao.getUserEmailChecked(userId);
	
	if(emailChecked == "true"){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미  인증 된 회원입니다.');");
		script.println("location.href = '../main.jsp'");
		script.println("</script>");
		return;
	}
	
	String host = "http://localhost:8080/todolist/user";
	String from = "eoaudehd0818@gmail.com";
	String to = userDao.getUserEmail(userId);
	String subject = "todo-list 이용을 위한 이메일 인증 메일입니다.";
	String content = "다음 링크에 접속하여 이메일 인증을 진행하세요." + 
		"<a href='" + host + "/emailCheckAction.jsp?code=" + new SHA256().getSHA256(to)
		+"'>이메일 인증하기</a>";
	Properties p = new Properties();
	p.put("mail.smtp.user",from);
	p.put("mail.smtp.host", "smtp.googlemail.com");
	p.put("mail.smtp.port","465");
	p.put("mail.smtp.starttls.enable","true");
	p.put("mail.smtp.auth","true");
	p.put("mail.smtp.debug","true");
	p.put("mail.smtp.socketFactory.port","465");
	p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback","false");
	
	try{
		Authenticator auth = new Gmail();
		Session ses = Session.getInstance(p, auth);
		ses.setDebug(true);
		MimeMessage msg = new MimeMessage(ses);
		msg.setSubject(subject);
		Address fromAddr = new InternetAddress(from);
		msg.setFrom(fromAddr);
		Address toAddr = new InternetAddress(to);
		msg.addRecipient(Message.RecipientType.TO, toAddr);
		msg.setContent(content, "text/html;charset=UTF8");
		Transport.send(msg);
	} catch(Exception e){
		e.printStackTrace();
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('오류가 발생했습니다.');");
		script.println("history.back();");
		script.println("</script>");
	}
%>


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
	<section class="mt-3" style="max-width: 560px;">
		<div class="alert alert-succeess mt-4" role="alert">
			이메일 주소 인증 메일이 전송되었습니다. 회원가입시 입력했던 이메일에 들어가셔서 인증하세요.
		</div>
	</section>
	<%@ include file='../include/footer.jsp' %>
</div>