<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%--
	1. HW3.jsp 파일
		- 회원 가입 form 만들기
		- post 방식
		- action="HW3_member_info.jsp"
		- 아이디(text) : name="userid"
		- 패스워드(password) : name="password"
		- 이메일(email) : name="email"
		- 이메일 수신여부(radio 버튼) : name = "emailAgree"
		- 관심사항(checkbox, 관심사항 4개 이상 설정) : name = "interest"
		- 핸드폰(text) : name ="phone"
		- 자기소개(<textarea>) : name = "introduce"
		- 전송 버튼(submit)
		
		
	2. MemberVO.java 파일
		- src.edu.web.homework 패키지에 MemberVO.java 클래스 생성
		- (변수들은 위의 form input name과 동일하게 작성)
		- MemberVO 기본 생성자 및 매개변수 생성자, getter/setter는 무조건 생성
		- String[] interest; (관심사항은 배열로 변수 선언)
		- request.getParameterValues() : checkbox로 선택된 여러 개의 데이터를 저장
		
			(hint bean을 쓰면 getParameter를 안쓰고 형변환 없이 바로 vo에서 데이터를 쓸수있다!)
			
	3. HW3_member_info.jsp 파일
	- (HW3.jsp에서 전송된 데이터를 출력)
	- request.getParameter or request.getParameterValues를 사용하지 않고 구현
	- 아래 코드를 추가하면 해결됨
		<jsp:useBean id="memeber" class="edu.web.homework.MemberVO" />
		<jsp:setProperty property="*" name="member" />
	
	 --%>
	<form action="HW3_member_info.jsp" method="post">
		<p>아이디 : <br><input type="text" name="userid"></p>
		<p>패스워드 : <br><input type="password" name="password"></p>
		<p>이메일 : <br><input type="email" name="email"></p>
		<p>이메일 수신여부 : <br>동의<input type="radio" name="emailAgree" value="동의">
						미동의<input type="radio" name="emailAgree" value="미 동의" checked="checked"></p>
		<p>관심사항 : <br>게임<input id="interest" type="checkbox" name="interest" value="게임">
						등산<input id="interest" type="checkbox" name="interest" value="등산">
					<br>영화관람<input id="interest" type="checkbox" name="interest" value="영화관람">
						독서<input id="interest" type="checkbox" name="interest" value="독서">
		<div id=checkText>모두 체크하세요</div>
		<p>핸드폰 : <br><input type="text" name="phone"></p>
		<p>자기소개 : <br><textarea name="introduce"></textarea></p>
		<input type="submit" id="submit" value="가입하기" >
	</form>
		
	<script>
		if(document.getElementById('interest').checked == true){
			console.log("돼나");
			document.getElementById('submit').disabled = true;
		}
	</script>
</body>
</html>