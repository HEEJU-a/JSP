<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	.hidden{ display:none;}
	.fa-heart{color: red;}
</style>
<script defer src="/res/js/boardDetail.js?ver=1"></script>

</head>
<body>
	<a href="list"><button>리스트돌아가기</button></a>
	<div>글번호 : ${param.iboard}</div>
	<div>제목 : ${data.title} 
	<c:if test="${data.isFav eq 0}">
		<a href="fav?iboard=${param.iboard}&fav=1"><i class="far fa-heart"></i></a>
	</c:if>
	<c:if test="${data.isFav == 1}">
		<a href="fav?iboard=${param.iboard}&fav=0"><i class="fas fa-heart"></i></a> 
	</c:if>
	</div>
	<div>내용 : ${data.ctnt}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>작성일 : ${data.regdt}</div>
	<c:if test="${loginUser.iuser == data.iuser}">
	<a href="del?iboard=${param.iboard}"><button>삭제</button></a>
	<a href="mod?iboard=${param.iboard}"><button>수정</button></a>
	</c:if>
	
	<div>
		<form id="insFrm" action="/board/cmt" method="post">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${param.iboard}">		
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
			</div>
		</form>
		
		<form id="updFrm" action="/board/cmt" method="post" class="hidden">
			<input type="hidden" name="icmt" value="0">
			<input type="hidden" name="iboard" value="${param.iboard}">		
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글수정">
				<input type="button" value="수정취소" onclick="showInsFrm();">
			</div>
		</form>
	</div>
	
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>비고</th>				
			</tr>	
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
						<c:if test="${loginUser.iuser == item.iuser}">
							<input type="button" value="수정"  onclick="updCmt(${item.icmt}, '${item.cmt.trim()}');">
							<button onclick="delCmt(${param.iboard}, ${item.icmt});">삭제</button>
							${param.iboard}
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>