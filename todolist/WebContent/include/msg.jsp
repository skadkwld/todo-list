<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<c:set var = "userId" value="${sessionScope.userId}"/>
<c:choose>
	<c:when test='${requestScope.msgId == 111}'>
		<c:set var='msg' value='추가 성공 : <b>[${userId}]</b>님, 할일을 추가했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 110}'>
		<c:set var='msg' value='추가 실패 : <b>[${userId}]</b>님, 할일을 추가하지 못했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 121}'>
		<c:set var='msg' value='수정 성공 : <b>[${userId}]</b>님, 할일을 수정했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 120}'>
		<c:set var='msg' value='수정 실패 : <b>[${userId}]</b>님, 할일을 수정하지 못했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 131}'>
		<c:set var='msg' value='삭제 성공 : <b>[${userId}]</b>님, 할일을 삭제했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 130}'>
		<c:set var='msg' value='삭제 실패 : <b>[${userId}]</b>님, 할일을 삭제하지 못했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 211}'>
		<c:set var='msg' value='추가 성공 : <b>[${userId}]</b>님, 한일을 추가했습니다'/>
	</c:when>
	
	<c:when test='${requestScope.msgId == 210}'>
		<c:set var='msg' value='추가 실패 : <b>[${userId}]</b>님, 한일을 추가하지 못했습니다.'/>
	</c:when>

</c:choose>