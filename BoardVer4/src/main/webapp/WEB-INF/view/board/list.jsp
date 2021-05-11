<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<h1>로그인성공</h1>
	<div>${loginUser.unm}님 (${loginUser.uid}) 환영합니다.
		<a href="/user/logout">Logout</a>
	</div>
	<div>
		<a href="write">글쓰기</a>
	</div>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.iboard }</td>
				<td>${item.title }</td>
				<td>${item.unm }</td>
				<td>${item.regdt }</td>
			
			</tr>
			</c:forEach>
		
		</table>
	</div>
</body>
</html>