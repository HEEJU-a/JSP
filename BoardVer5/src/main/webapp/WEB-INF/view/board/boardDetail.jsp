<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<div>글번호 : ${param.iboard}</div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>작성일 : ${data.regdt}</div>
	<c:if test="${loginUser.iuser == data.iuser}">
	<a href="del?iboard=${param.iboard}"><button>삭제</button></a>
	<a href="mod?iboard=${param.iboard}"><button>수정</button></a>
	</c:if>
</body>
</html>