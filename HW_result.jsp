<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산 결과</title>
</head>
<body>
	<% 
	int money = Integer.parseInt(request.getParameter("money"));
	int date = Integer.parseInt(request.getParameter("date"));
	double interest = Double.parseDouble(request.getParameter("interest"));
	System.out.println(money+", "+date+","+interest);
	
	//int moneySec = (Integer) request.getAttribute("money");
	//System.out.println(moneySec);
	
	int totalInputMoney = money * date;
	double totalInterest = totalInputMoney * interest / 100;
	double totalReceiveMoney = totalInterest + totalInputMoney;
	
	DecimalFormat df = new DecimalFormat("￦###,###,###");
	%>
	<h1>계산 결과</h1>
		<p>월 적금액 = <%=money %></p>
		<p>납입 기간 = <%=date %></p>
		<p>이자율 = <%=interest %></p>
		
		<hr>
	<p>총 납입 금액 : <%=df.format(totalInputMoney) %></p>
	<p>발생 이자 : <%=df.format(totalInterest) %></p>
	<p>총 수령액 : <%=df.format(totalReceiveMoney) %></p>
		
</body>
</html>