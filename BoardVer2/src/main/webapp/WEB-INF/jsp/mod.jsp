<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form action="/mod" method="post">
	<div>제목 : <input type="text" name="title" value="${vo.title}"></div>
	<div>내용 : <textarea name="ctnt">${vo.ctnt }</textarea></div>
	<input type="hidden" name="no" value="${param.no}">
	<input type="submit" value="글수정">
	
	</form>
</body>
</html>