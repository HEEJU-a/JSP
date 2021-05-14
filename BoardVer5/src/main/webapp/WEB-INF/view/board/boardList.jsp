<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
	table, tr, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		}
		
	.record{cursor: pointer;}
	.record:hover{background-color: #ecf0f1;}

</style>
</head>
<body>
	<div>${loginUser.unm}(${loginUser.uid})님 환영합니다.</div>
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
			
			<c:forEach var="i" items="${data}">
			<tr class="record" onclick="moveToDetail(${i.iboard})">
				<td>${i.iboard}</td>
				<td>${i.title}</td>
				<td>${i.unm}</td>
				<td>${i.regdt}</td>
			</tr>
			</c:forEach>
		</table>
	
	</div>
	<script>
		function moveToDetail(iboard){
			location.href='detail?iboard=' + iboard;
		}
	</script>
	
</body>
</html>