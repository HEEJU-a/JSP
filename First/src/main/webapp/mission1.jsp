<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission1</title>
</head>
<body>
	<div>스크립틀릿 이해를 하였는가 미션1</div>
	<div>for문을 이용하여 1부터 10이 세로 방향으로 찍히도록 해주세요.</div>
	<div>각 숫자들은 div로 감싸주세요..</div>
	
	<%
		for(int i = 1; i <= 10; i++){
	%><div><%= i%></div><% 
		}
	%>
	
	<hr>
	<%
		for(int i = 1; i <= 10; i++){
			out.print("<div>");
			out.print(i);
			out.print("<div>");
		}
	%>
		
	
</body>
</html>