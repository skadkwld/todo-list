<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/lib.jsp" %>

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
<div class="container" > 
	<%@ include file="include/head.jsp" %>
	
	<div class="alert alert-info alert-dismissible fade show">
		<p class="mb-0">할일 혹은 한일 메뉴를 선택하세요</p>
		<button type="button" class="close" data-dismiss="alert">
			<span>&times;</span>
		</button>
	</div>	
</div>