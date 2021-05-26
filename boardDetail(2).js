var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');

function regCmt(){
	var cmtVal = cmtFrmElem.cmt.value;
	
	console.log(cmtFrmElem.dataset.iboard);
	
	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt : cmtVal
		
	};
	
	regAjax(param);
}

//서버에게 등록해줘~~~~~~~~~
function regAjax(param){
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};
	
	fetch('cmtInsSel', init)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		switch(myJson.result){
			case 0:
				alert('등록 실패!');
			break;
			case 1:
				cmtFrmElem.cmt.value = '';
				getListAjax();
			break;
		}
	});
}

//서버 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax(){
	var iboard = cmtListElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		makeCmtElemList(myJson);
	});
}

function makeCmtElemList(data){
	//var cmtListElem = document.querySelector('#cmtList');
	cmtListElem.innerHTML = ''; // 여기서 innerhtml줘도 되고 이거 줘도 됨
	
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');
	
	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';
	
	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);
	
	tableElem.append(trElemTitle);
	
	cmtListElem.append(tableElem);
	
	var loginUserPk = cmtListElem.dataset.login_user_pk;
	
	data.forEach(function(item){
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');
		 
		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);
		//일단 버튼은 스킵!
		if(parseInt(loginUserPk) === item.iuser){
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
			//삭제버튼 클릭시 
			delBtn.addEventListener('click', function() {
				delAjax(item.icmt);
			});
			
			
			delBtn.innerText = '삭제';
			modBtn.innerText = '수정'; // modBtn.value는 안됨!
			
			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}
		
		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);
		
		tableElem.append(trElemCtnt);
	})
	
}

function delAjax(icmt){
	fetch('cmtDelUpd?icmt=' + icmt)
	.then(function(res){
		return res.json();
	})
	.then(function(data){ // ->여기 data자체가 {result: 0} ->여기에 접근한다 그래서 
	                      // 삭제가 잘됐으면 여기에 1이 넘어올꺼고 안됐으면 0이 넘어옴
		console.log(data);
		
		switch(data.result){
			case 0:
				alert('댓글 삭제를 실패하였습니다.');
			break;
			case 1:
				getListAjax();
			break;
		}
	});
}

getListAjax(); //이 파일이 임포트 되면 함수 1회호출











