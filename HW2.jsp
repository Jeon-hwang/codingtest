<%@page import="java.text.SimpleDateFormat"%>
<%@page import="edu.web.homework.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	font-family : arial, sans-serif;
	border-collapse : collapse;
	width : 100%;
}
td, th{
	border : 1px solid #dddddd;
	text-align :Left;
	padding : 8px
	}
</style>
</head>
<body>
	<%
		ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-mm-dd");
	%>
	<table>
		<thead>
			<tr>
			<th>게시판 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i=0; i<list.size();i++){ %>
			<tr>
			<td><%=list.get(i).getBoardId() %></td>
			<td><%=list.get(i).getBoardTitle() %></td>
			<td><%=list.get(i).getUserId() %></td>
			<td><%=dFormat.format(list.get(i).getBoardRegDate()) %></td>	
			</tr>
		<% }%>
		</tbody>
		
	</table>
</body>
</html>