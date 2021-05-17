<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet" href='/res/css/boardList.css'>
<script defer src="/res/js/boardList.js?ver=1"></script>
</head>
<body>
	<h1>${sessionScope.loginUser.unm}(${loginUser.uid})님 환영합니다.</h1>
	<a href="write"><button>글쓰기</button></a>
	<a href="/user/logout"><button>로그아웃</button></a>
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach var="i" items="${requestScope.data}">
			<tr class="record" onclick="moveToDetail(${i.iboard})">
				<td>${pageScope.i.iboard}</td>
				<td>${i.title}</td>
				<td>${i.unm}</td>
				<td>${i.regdt}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	
</body>
</html>