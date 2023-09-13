<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록 페이지</title>
</head>
<body>
	<%
		// TODO : 회원 가입 form 생성. action = "register.do" method="post"
	%>
	<h2>회원 가입</h2>
		<form action="register.do" method="post">
			<p>아이디(*) : <br>
			<input type="text" name="memberId" placeholder="아이디 입력" required="required" maxlength="30"></p>
			<p>패스워드(*) : <br>
			<input type="password" name="password" placeholder="비밀번호 입력" required="required" maxlength="30"></p>
			<p>이메일(*) : <br>
			<input type="email" name="email" placeholder="이메일 입력" required="required" maxlength="50"></p>
			<p>이메일 수신 동의 여부(*) <br>  
			동의<input type="radio" name="emailAgree" value="동의함"><br>
			동의하지 않음<input type="radio" name="emailAgree" value="동의하지 않음" checked="checked"></p>
			<p>선호하는 장르 (선택사항) <br>
			<input type="checkbox" name = "interest" value="RPG">RPG 
			<input type="checkbox" name = "interest" value="FPS">FPS 
			<input type="checkbox" name = "interest" value="시뮬레이션">시뮬레이션<br> 
			<input type="checkbox" name = "interest" value="전략">전략 
			<input type="checkbox" name = "interest" value="퍼즐">퍼즐
			<input type="checkbox" name = "interest" value="보드">보드</p>
			<p>휴대전화(*) : <br> 
			<input type="tel" name="phone" placeholder="휴대전화 입력" required="required" maxlength="40"></p>
			<p>자기소개(*) : <br>
			<textarea name="introduce"  rows="5" cols="30" placeholder="자기소개 입력" required="required" maxlength="500"></textarea></p>
			
			<input type="submit" value="가입하기">
		</form>
		<p> (*)은 필수입력 입니다</p>
</body>
</html>