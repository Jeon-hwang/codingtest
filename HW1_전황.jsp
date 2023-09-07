<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>적금 계산기</title>
</head>
<body>
	<%--
		JSP 파일 생성(적금 계산 결과 페이지)
		1. 월 적금액, 기간, 이자율을 전송하는 form 만들기(HW.jsp)
		- <form action="HW1.result.jsp" Method="GET">
		2. 월 적금액, 기간, 이자율을 전송받아 계산하여
			출력하는 jsp 파일 만들기(HW1_result.jsp)
	 --%>
	 
	 
	 <h1>적금 계산기</h1>
	 <form action="HW_result.jsp" method="GET">
	 	적금액수 : <input type="number" name="money">원 <br>
	 	기간 : <input type="number" name="date">개월 <br>
	 	이자율 : <input type="text" name="interest">% <br>
	 	<input type="submit" value="전송">
	 </form>
	 <%--
	 	 	 <%! 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/HW_result.jsp");
			dispatcher.forward(request, response);
			
		} %> 없어도 넘어가지네;
	  
	  
	  <%
	  	request.setAttribute("money", request.getParameter("money"));
	  %>
	  --%>
</body>
</html>