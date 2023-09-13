<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
<%
	// TODO : 세션을 이용, "userid님 , 환영합니다." 라고 화면에 출력
	
	// TODO : 회원 정보 보기 버튼 생성
	
	// TODO : 로그 아웃 버튼 생성
	String memberId = (String) session.getAttribute("memberId");
	if(memberId==null){
		out.print("<script>alert('로그인 해주세요!!');");
		out.print("location.href='login.jsp'</script>");
	}
%>
	<h2><%=memberId %>님, 환영합니다.</h2>
	<!--  session으로 회원 정보 및 로그아웃 기능 수행 (핵심)-->
	<!--  location.href로 이동하면 servlet에서 doGet()으로 수행
	(이 상황에서는 원래 좋은방법은 아니나 과제를 위해서 어쩔수없이 get방식으로 수행 -->
	<button onclick="location.href='select.do'">회원정보</button>
	<button onclick="location.href='logout.do'">로그아웃</button>
	

</body>
</html>