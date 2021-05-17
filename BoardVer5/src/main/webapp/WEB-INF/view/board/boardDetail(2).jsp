<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
<script defer src="/res/js/boardDetail.js"></script>

</head>
<body>
	<a href="list"><button>리스트돌아가기</button></a>
	<div>글번호 : ${param.iboard}</div>
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>
	<div>글쓴이 : ${data.unm}</div>
	<div>작성일 : ${data.regdt}</div>
	<c:if test="${loginUser.iuser == data.iuser}">
	<a href="del?iboard=${param.iboard}"><button>삭제</button></a>
	<a href="mod?iboard=${param.iboard}"><button>수정</button></a>
	</c:if>
	
	<div>
		<form action="/board/cmt" method="post">
			<input type="hidden" name="iboard" value="${param.iboard}">		
			<div>
				<textarea name="cmt" placeholder="댓글내용"></textarea>
				<input type="submit" value="댓글작성">
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
							<input type="button" value="수정">
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