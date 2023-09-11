<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

</head>
<body>
<% 
		Cookie[] cookies = request.getCookies();// 저장된 쿠키값을 가져온다
		String inputId = "";
		String inputPassword = "";
		//System.out.println(cookies.length);
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("id")){
					out.print("저장된 아이디 : "+cookie.getValue()+"<br>");
					inputId = cookie.getValue();
				}
				if(cookie.getName().equals("password")){
					out.print("저장된 패스워드 : "+cookie.getValue()+"<br>");
					inputPassword = cookie.getValue();
				}
			
			}
		}
	%>
	<form action="12_cookie_practice_result.jsp" method= "post">
		아이디<br>
		<input type="text" id="cid" name="id" value="<%=inputId%>"><br><!-- JSP에서는 변수의 위치 관계가 없다는것을 이용함 -->
		비밀번호<br>
		<input type="password" id="cpassword" name="password" value="<%=inputPassword%>"> <br>
		<input type="checkbox" id="isAgreed" name="isSaveAgreed" value="agreed">
		아이디 저장 <br><br>
		<input type="submit" value="로그인">	
	</form>
	<!-- 아이디 저장을 체크
		 ㄴ 12_cookie_practice_input.jsp에 입력한 아이디 / 비밀번호가 출력
		 ㄴ 쿠키에 저장하여 지속적으로 출력되도록
		 
 	 -->
	
	<script>
	<%
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("id")){%>
		document.getElementById("cid").value = "<%=inputId%>";
		document.getElementById("cpassword").value = "<%=inputPassword%>";
		document.getElementById("isAgreed").checked = true;
		<%}// 자바스크립트로 하면 시점문제가 생겨서 위험할 수 있음 
	}%>



	
	
	
	</script>
</body>
</html>