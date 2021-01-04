<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/lib.jsp" %>
<div class="container">
	<%@ include file='../include/head.jsp' %>
	<form action="../todo" method="post">
		<label>할일 : </label>
		<input type="text" name="title" required/>
		<label>날짜 : </label>
		<input type="date" name="todoDate" required/>
		<input type="submit" value="등록"/>
	</form>
</div>