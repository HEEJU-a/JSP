<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.koreait.board.BoardVO" %>
	
	<%	 
		String no = request.getParameter("no"); 
	 	BoardVO vo = (BoardVO) request.getAttribute("data");
	
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<h1>디테일<%=no %></h1>
	
	<div><%=request.getParameter("no") %></div> <!-- 이렇게 해도 됨 --> 
	
	<div>
		<form action="/del" method="post">
			<input type = "hidden" name = "no" value="<%=no %>">
			<input type = "submit" value="삭제">
		</form>
		
		<a href="/del?no=<%=no %>"><button>삭제</button></a><!-- 이렇게 get방식으로 사용해도 됨 -->
		
	</div>
	
	<div>제목 : <%=vo.getTitle() %></div>
	<div><%=vo.getCtnt() %></div>
	
</body>
</html>