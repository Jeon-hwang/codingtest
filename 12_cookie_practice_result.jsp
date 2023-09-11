<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 페이지</title>
</head>
<body>
	<!--
	 아이디 비밀번호를 전송받아서 쿠키에 저장(아이디 저장을 체크한 경우) 
	 쿠키 유지 시간은 60분
	 <p>태그를 이용하여(아이디)님, 환영합니다.를 출력	
	-->
		<h1>로그인 결과 화면</h1>
		<p><%=request.getParameter("id")%>님, 환엽합니다~</p> 
	<%	
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
		out.print("<p>"+id+"님, 환영합니다!</p");
		
		Cookie[] cookies = request.getCookies();
		
		Cookie idCookie;
		Cookie passwordCookie;
	//System.out.println(request.getParameter("isSaveAgreed"));
		if(request.getParameter("isSaveAgreed") != null){ // 아이디 저장이 체크된 경우

		//System.out.println("체크하였음");			
		
		idCookie = new Cookie("id",id);
		passwordCookie = new Cookie("password",password);
		
		idCookie.setMaxAge(60*60);
		passwordCookie.setMaxAge(60*60);
		
		response.addCookie(idCookie);
		response.addCookie(passwordCookie);
		}else{ // 체크안할경우 밑에 출력 없애버리기
			System.out.println("체크안함");
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("id")){
					cookie.setMaxAge(1);
					response.addCookie(cookie);
				}
				if(cookie.getName().equals("password")){
					cookie.setMaxAge(1);
					response.addCookie(cookie);
				}
			}
			
		}
		
		
	%>
		

</body>
</html>