<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script>
<c:if test="${!empty iCnt}">
	<c:if test="${iCnt eq 1}">
		alert("저장성공");
		location.href="/url/atproductinfo:list";
	</c:if>
</c:if>
</script>
<style>
input[type=text], select {
	width: 60%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

button[type=button] {
	width: 60%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button[type=button]:hover {
	background-color: #45a049;
}
input[type=button] {
	width: 60%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=button]:hover {
	background-color: #45a049;
}
input[type=file] {
	width: 60%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=file]:hover {
	background-color: #45a049;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
<body>

	<h3>제품 등록 란</h3>

	<div>
			<form id="fileForm" action="fileUpload" method="post" enctype="multipart/form-data"> <br />
			<!-- 1 -->
			<label for="productName">제품 명</label> <input type="text"
				id="productName" name="productName" placeholder="제품명을 입력해 주세요">
			<br>
			<!-- 2 -->
			<label for="productCode">제품 코드</label> <input type="text"
				id="productCode" name="productCode"
				placeholder="제품코드는 여기에 쓸필요 없지요 내가 써야지"> <br>
			<!-- 3 -->
			<label for="productQuantity">제품 수량</label> <input type="text"
				id="productQuantity" name="productQuantity" placeholder="판매 수량 (숫자)">
			<br>
			<!-- 4 -->
			<label for="productDate">제품 등록일</label> <input type="text"
				id="productDate" name="productDate" placeholder="제품 등록일은 커밋하는 그순간">
			<br>
			<!-- 5 -->
			<label for="productName">제품 최저가</label> <input type="text"
				id="productLowestPrice" name="productLowestPrice"
				placeholder="제품의 최저가(시작가)"> <br>
			<!-- 6 -->
			<label for="productHopefulPrice">제품 희망가</label> <input type="text"
				id="productHopefulPrice" name="productHopefulPrice"
				placeholder="제품 희망가(즉시 구매가)"> <br>
			<!-- 7 -->
			<label for="productDesc">제품 설명</label> <input type="text"
				id="productDesc" name="productDesc" placeholder="제품의 설명"> <br>
			<!-- 8 -->
			<label for="productBrand">제품 브랜드</label> <input type="text"
				id="productBrand" name="productBrand" placeholder="제품명의 브랜드">
			<br>
			<!-- 9 -->
			<label for="productCondition">제품 상태</label> <input type="text"
				id="productCondition" name="productCondition"
				placeholder="제품의 상태(자세히)"> <br>
			<!-- 10 -->
			<label for="productImage">제품 사진(이미지)</label> <input type="text"
				id="productImage" name="productImage" placeholder="제품의 이미지 넣을 버튼만들자">
			<br>
				<input type="file" id="fileUp" /> <br />
				 <input type="button" value="전송하기" onClick="fileSubmit();"> <br />
			<!-- 11 -->
			<label for="productCategory">제품 분류</label> <select
				id="productCategory" name="productCategory">
				<option value="australia">의류</option>
				<option value="canada">가전제품</option>
				<option value="usa">뭐가 있을까</option>
			</select>
			<button type="button" onclick="addATProductInfo">제품 등록</button>
		</form>

	</div>
	<script>
	
	</script>
</body>
</html>
