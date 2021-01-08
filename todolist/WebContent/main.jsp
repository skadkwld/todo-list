<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/lib.jsp" %>

<div class="container" > 
	<%@ include file="include/mainHead.jsp" %>
	<div class="alert alert-info alert-dismissible fade show">
		<p class="mb-0"><b>[${sessionScope.userId}]</b>님, 할일 혹은 한일 메뉴를 선택하세요</p>
		<button type="button" class="close" data-dismiss="alert">
			<span>&times;</span>
		</button>
	</div>	
	<%@ include file='include/footer.jsp' %>
</div>

