<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<input type = "text" id="num1" value = "123">
		<input type = "text" id="num2" value = "하">
		<button onclick= "sum();">더하기</button>
	</div>
	
	<div>
		<input type = "text" id="result">
		
	</div>
	
	<script>
		var num1Elem = document.getElementById('num1');
		var num2Elem = document.querySelector('#num2');
		var resultElem = document.querySelector('#result');
		
		function sum(){
			var num1 = num1Elem.value;
			console.log('num1 : %s', num1);
			
			resultElem.value = '123'; 
		}
		
	</script>
</body>
</html>