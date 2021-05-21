<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<div>
		<a href="login">login으로 이동</a>
	</div>
	<form id = "frm">
	<div><input type="text" name="uid" placeholder="아이디"></div>
	<div><input type="password" name="upw" placeholder="비밀번호"></div>
	<div><input type="text" name="unm" placeholder="name"></div>
	<div>
		성별 : 
		<label>여성<input type="radio" name="gender" value="0" checked></label>
		<label>남성<input type="radio" name="gender"value="1"></label>
	</div>
	</form>
	
	<input type="button" value="회원가입" onclick="join();">
	<script>
		function join(){
			var frmElem = document.querySelector('#frm');
			var uid = frmElem.uid.value;
			var upw = frmElem.upw.value;
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;
			
			console.log('uid : ' + uid);
			console.log('upw : ' + upw);	
			console.log('unm : ' + unm);
			console.log('gender : ' + gender);
	
			var param = {uid, upw, unm, gender};
			ajax(param);
		
		}
		
		function ajax(param){
			const init = {
					method: 'POST',
					headers:{
						'Content-Type': 'application/json',
					},
					body: JSON.stringify(param)
			}
			fetch('/user/join', init)
			.then(function(res){return res.json();})
			.then(function(myJson){
				//console.log(myJson);
				switch(myJson.result){
				case 0:
					alert('회원가입 실패');
					break;
				case 1:
					location.href='/user/login';
					break;
				}
			});
		}
	</script>
</div>