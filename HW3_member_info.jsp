<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<!-- 아무튼 bean은 vo에 선언된 변수이름을 property에 가져온다 -->
	<% 
		request.setCharacterEncoding("UTF-8");
		String[] interest = request.getParameterValues("interest");
	%>
	<jsp:useBean id="member" class="edu.web.homework.MemberVO"></jsp:useBean>
	<jsp:setProperty property="*" name="member"/>
	<h2>회원 확인</h2>
	
	<p>아이디 : <jsp:getProperty property="userid" name="member"/></p>
	<p>패스워드 : <jsp:getProperty property="password" name="member"/></p>
	<p>이메일 : <jsp:getProperty property="email" name="member"/></p>
	<p>이메일 수신여부 :  <jsp:getProperty property="emailAgree" name="member"/></p>
					
	<p>관심사항 : 
		<% for(int i=0 ; i<interest.length ; i++){ %> 
				<%=interest[i] %>
			<%	} %> 
	</p>
	
	<p>핸드폰 : <jsp:getProperty property="phone" name="member"/></p>
	<p>자기소개 : <jsp:getProperty property="introduce" name="member"/></p>
</body>
</html>