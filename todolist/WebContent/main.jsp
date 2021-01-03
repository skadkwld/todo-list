<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/lib.jsp" %>
<title>Just Do</title>
<%-- <c:choose>
	<c:when test="${sessionScope.userId eq 'user' }">
		<c:redirect url="/todo/listTodo.jsp"/>
	</c:when>
	<c:otherwise>
		<a href="user/login.jsp">로그인</a><br>
		${requestScope.msg }
	</c:otherwise>
</c:choose>
  --%>
  
  <a href = "/todolist/todo/listTodo">todo list 보기</a>