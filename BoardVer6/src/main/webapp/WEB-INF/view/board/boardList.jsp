<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>리스트</h1>
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
	
