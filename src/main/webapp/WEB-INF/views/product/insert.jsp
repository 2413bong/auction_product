<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>

	<h3>Using CSS to style an HTML Form</h3>

	<div>
		<form action="/action_page.php">
			<label for="productName">제품 명</label> 
			<input type="text" id="productName"  name="productName" placeholder="제품명을 입력해 주세요"> 
			<label for="productCode">제품코드</label>
			<input type="text" id="productCode" name="productCode" placeholder="제품코드는 여기에 쓸필요 없지요 내가 써야지"> 
			<label for="productQuantity">제품 수량</label> 
			<input type="text" id="productQuantity"  name="productQuantity" placeholder="판매 수량"> 
			<label for="lname"></label>
			<input type="text" id="lname" name="lastname" placeholder="Your last name.."> 
			<label for="productName">제품 명</label> 
			<input type="text" id="productName"  name="productName" placeholder="제품명을 입력해 주세요"> 
			<label for="lname"></label>
			<input type="text" id="lname" name="lastname" placeholder="Your last name.."> 
			
			<label for="productCategory">제품 분류</label>
			 <select id="productCategory" name="productCategory">
				<option value="australia">의류</option>
				<option value="canada">가전제품</option>
				<option value="usa">뭐가 있을까</option>
			</select> 
			<label for="productQuantity">판매 수량</label>
			 <select id="productQuantity" name="productQuantity">
				<option value="australia">1</option>
				<option value="canada">2</option>
				<option value="usa">뭐가 있을까</option>
			</select> 
			<input type="submit" value="Submit">
		</form>
	</div>


<img src="/resource/img/uncha.jpg">
</body>
</html>
