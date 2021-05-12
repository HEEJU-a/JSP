<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ${data.title}</title>
</head>
<body>
	<h1>디테일페이지</h1>
	<a href="list"><button>리스트돌아가기</button></a>
	<div>${param.iboard}</div>
	<div>글의 pk 즉(iboard) 값 찍히도록 하기</div>
	<div>글번호 : ${data.iboard}</div>
	<div>제목 : ${data.title}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>작성일 : ${data.regdt}</div>
	<div>내용 : ${data.ctnt}</div>
	
	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="/board/del?iboard=${param.iboard}"><button>삭제</button></a>
		<a href="/board/mod?iboard=${param.iboard}"><button>수정</button></a>
	</div>
	</c:if>
</body>
</html>