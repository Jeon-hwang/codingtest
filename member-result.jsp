<%@page import="edu.web.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 페이지</title>
</head>
<body>
	
	<%
		// TODO : 회원 정보 출력
		// TODO : 회원 수정 버튼 생성(member-upadate.jsp) 둘다 세션
		// TODO : 회원 탈퇴 버튼 생성(delete.do)
		MemberVO vo =  (MemberVO) request.getAttribute("vo");
		String memberId = (String) session.getAttribute("memberId");
		//System.out.println("세션 아이디?? "+memberId);
		if(memberId == null){
			//System.out.println("작동????");
			
			out.print("<script>alert('로그인 해주세요!!');");
			out.print("location.href='login.jsp'</script>");
			out.close();
		}
		
		session.setAttribute("memberId", vo.getMemberId());
		
		
	%>
	<h2>회원 정보</h2>
	<p>ID : <%=memberId %></p>
	<p>PASSWORD : <%= vo.getPassword() %></p>
	<p>E-Mail : <%=vo.getEmail() %></p>
	<p>이메일 수신 여부 : <%=vo.getEmailAgree() %></p>
	<p>관심 사항 : <%=vo.joinInterest() %></p>
	<p>휴대폰번호 : <%=vo.getPhone() %></p>
	<p>자기소개 : <%=vo.getIntroduce() %></p>
	<button onclick="location.href='member-update.jsp'">회원 수정</button>
	<button onclick="location.href='delete.do'">회원 탈퇴</button>
</body>
</html>