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
	<div>
	${loginUser.unm}님 (${loginUser.uid}) 환영합니다.
	</div>
	<div>
		<a href="/user/logout"><button>Logout</button></a>
		<a href="write"><button>글쓰기</button></a>
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
			<tr onclick="moveToDetail(${item.iboard});">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.unm}</td>
				<td>${item.regdt}</td>
			
			</tr>
			</c:forEach>
		
		</table>
	</div>
	
	<script>
		function moveToDetail(iboard){
			location.href='/board/detail?iboard=' + iboard;
		}
	</script>
</body>
</html>