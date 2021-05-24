<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	id vs class
	유일하게 주는건 주로 id, 여러게 주는건 주로 class를 쓴다
 -->


<form id="frm" action="join" method="post" onsubmit="return frmChk();">
	<div>
		<input type="text" name="uid" placeholder="아이디">
		<input type="button" id="btnChkId" value="중복ID체크">
	</div>
	<div id="chkUidResult"></div>
	<div><input type="password" name="upw" placeholder="비밀번호"></div>
	<div><input type="password" name="chkUpw" placeholder="비밀번호 확인"></div>
	<div>
		성별 : 
		<label>여성<input type="radio" name="gender" value="0" checked></label>
		<label>남성<input type="radio" name="gender" value="1"></label>
	</div>
	<div><input type="text" name="unm" placeholder="이름"></div>
	<div>
		<input type="submit" value="회원가입">
		<input type="reset" value="초기화">
	</div>
</form>

<script defer src="/res/js/userJoin.js"></script>
