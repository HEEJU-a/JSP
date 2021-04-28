<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    	String name = "홍길동";
    	pageContext.setAttribute("name", "A");
    	request.setAttribute("name", "B");
    	session.setAttribute("name", "C");
    	application.setAttribute("name", "D");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	<a href="/del?no=${param.no}"><button>삭제</button></a>
	<a href="/mod?no=${param.no}"><button>수정</button></a>
	<div>제목 : ${vo.title}</div>
	<div>${vo.ctnt}</div>
 

</body>
</html>