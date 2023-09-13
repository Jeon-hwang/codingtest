<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 페이지</title>
</head>
<body>
	<%
		//TODO : session에서 userid 값을 저장
		//TODO : form action="update.do" method="post"생성
		//TODO : userid를 제외한 모든 정보 수정 가능하게 input 태그 작성
		//		 userid는 읽기만 가능하도록 input 태그 설정
		String memberId = (String) session.getAttribute("memberId");
		if(memberId == null){
			out.print("<script>alert('로그인 해주세요!!');");
			out.print("location.href='login.jsp'</script>");
			out.close();
		}
	%>
	<h2> 회원 정보 수정 </h2>
	<form action="update.do" method="post">
		<p>아이디 : <br> <input type="text" name="memberId" readonly="readonly" value="<%=memberId%>"></p>
		<p>패스워드 : <br> <input type="password" name="password" placeholder="수정할 비밀번호 입력" required="required" maxlength="30"></p>
		<p>이메일 : <br> <input type="email" name="email" placeholder="수정할 메일주소 입력" required="required" maxlength="50"></p>
		<p>이메일 수신여부 : <br>
			동의<input type="radio" name="emailAgree" value="동의함"><br>
			동의하지 않음<input type="radio" name="emailAgree" value="동의하지 않음" checked="checked"></p>
		<p>선호하는 장르 :  <br>
			<input type="checkbox" name = "interest" value="RPG">RPG 
			<input type="checkbox" name = "interest" value="FPS">FPS 
			<input type="checkbox" name = "interest" value="시뮬레이션">시뮬레이션<br> 
			<input type="checkbox" name = "interest" value="전략">전략 
			<input type="checkbox" name = "interest" value="퍼즐">퍼즐
			<input type="checkbox" name = "interest" value="보드">보드</p>
		<p>휴대전화 : <br> <input type="tel" name="phone" placeholder="휴대전화 입력" required="required" maxlength="40"></p>
		<p>자기소개 : <br> 
		<textarea name="introduce"  rows="5" cols="30" placeholder="자기소개 입력" required="required" maxlength="500"></textarea>></p>
		
		<input type="submit" value="수정하기">		
		
	</form>
</body>
</html>