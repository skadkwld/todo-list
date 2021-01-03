<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/lib.jsp" %>
<%
	pageContext.setAttribute("todoList",request.getAttribute("todoList"));
%>
<div class="container">
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th>Date</th><th>To Do</th><th></th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${todoList.size() > 0}">
					<c:forEach var="todo" items="${todoList}">
						
						<tr>
							<td>${todo.todoDate }</td>
							<td>${todo.title }</td>
							<td>
								<a class="btn btn-primary" 
									href="viewTodo?todoNum=${todo.todoNum}">자세히</a>
							</td>
						</tr>
						
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><td colspan="4" class="text-center">사원이 없습니다.</td></tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div> 
<a class="btn btn-primary" href = "addTodo.jsp">추가</a>
