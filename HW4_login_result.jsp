<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login result</title>
</head>
<body>

	
	<% 
	String getId = (String) session.getAttribute("id");
	if(!getId.equals("test")){
		out.print("<script>alert('로그인 해주세요!!');");
		out.print("location.href='HW4.jsp'</script>");
	}
	%>
	<h2>ID : <%=getId %></h2> 
	
</body>
</html>