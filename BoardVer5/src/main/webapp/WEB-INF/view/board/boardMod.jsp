<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<form action="mod" method="post">
	<div><input type="hidden" name="iboard" value="${param.iboard}"></div>
	<div>제목 : <input type="text" name="title" value="${data.title}"></div>
	<div>내용 : <textarea name="ctnt">${data.ctnt}</textarea></div>
	<input type="submit" value="수정하기">
	<input type="reset" value="초기화">	
	</form>
</body>
</html>