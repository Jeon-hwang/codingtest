<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login access</title>
</head>
<body>
	<%
		session.setMaxInactiveInterval(60*60);
	
		session.setAttribute("id",request.getParameter("id"));
		session.setAttribute("password", request.getParameter("password"));
		
		
		
		if(session.getAttribute("id").equals("test") &&
			session.getAttribute("password").equals("1234")){
			out.print("<script>location.href='HW4_login_result.jsp'</script>");
		}else{
			out.print("<script>location.href='HW4.jsp'</script>");
		}
	%>
</body>
</html>