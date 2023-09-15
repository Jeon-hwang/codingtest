<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	전송된 데이터가
	만약 'a'로 시작하면 "apple"
	만약 'b'로 시작하면 "banana"
	만약 'c'로 시작하면 "coconut"
	그게 아니면 "not fruits"를 돌려줘라!
	
--%>

<c:choose>
	 		<c:when test="${param.flag == 'a'}">
	 			<p>apple</p>
	 		</c:when>
	 		<c:when test="${param.flag == 'b'}">
	 			<p>banana</p>
	 		</c:when>
	 		<c:when test="${param.flag == 'c'}">
	 			<p>coconut</p>
	 		</c:when>
	 		<c:when test="${param.flag == ''}">
	 			<p></p>
	 		</c:when>
	 		<c:otherwise>
	 			<p>not fruits</p>
	 		</c:otherwise>
</c:choose>

