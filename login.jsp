<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<%
	// TODO : <a>태그를 이용하여 member-register.jsp 이동 링크 생성
	// TODO : 로그인 form 생성. action="login_auth.do" method="post"
	

%>
<h2>로그인 창</h2>
	<form action="login_auth.do" method="post">
		<p>아이디 <br>
		<input type="text" name="memberId" required="required" maxlength="30"></p>
		<p>패스워드 <br>
		<input type="password" name="password" required="required" maxlength="30"></p>
		<input type="submit" value="로그인">
		 <a href='member-register.jsp'>회원가입</a>
	</form>
	
</body>
</html>