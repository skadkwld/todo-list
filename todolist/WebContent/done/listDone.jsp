<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/lib.jsp" %>
<%
	pageContext.setAttribute("doneList",request.getAttribute("doneList"));
%>
<div class="container">
	<%@ include file='../include/head.jsp' %>
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>Date</th><th>Done</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${doneList.size() > 0}">
					<c:forEach var="done" items="${doneList}">
						<tr>
							<td>${done.doneDate }</td>
							<td>${done.title }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td colspan="4" class="text-center">한일목록이 비었습니다.</td></tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div> 


