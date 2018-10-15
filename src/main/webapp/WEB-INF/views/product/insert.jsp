
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script>
<c:if test="${!empty iCnt}">
	<c:if test="${iCnt eq 1}">
		alert("저장성공");
		location.href="/atproductInfo";
	</c:if>
</c:if>

</script>
<!--   --><style>
input[type=text], select {
	width: 60%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
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

</style>
<body>

	<h3>제품 등록 란</h3>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">제품등록</h1>
		<h2 class="sub-header">Section title</h2>
		
		<form enctype="multipart/form-data" method="POST">
			<br />
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
			<label for="productCategory">제품 분류</label> <select
				id="productCategory" name="productCategory">
				<option value="australia">의류</option>
				<option value="canada">가전제품</option>
				<option value="usa">뭐가 있을까</option>
			</select>
			<br>
			<!-- 11 -->
			<label for="productImage">제품 사진(이미지)</label> 
			   <input	type="file" name="productImage"><br>
			   <input type="file" class="custom-file-input" id="productImage">
               <label class="custom-file-label" for="productImage">Choose file</label>
			<br>
			<button type="button" name="ATProductInfo" >업로드하기</button>

		</form>

	</div>

	<script>
/* 	function insertATProductInfo(){
		var form = document.querySelector('form');
		var productname = document.querySelector("#productname").value;
		var productcategory = document.querySelector("#productcategory").value;
		var productcode = document.querySelector("#productcode").value;
		var productquantity = document.querySelector("#productquantity").value;
		var productdate = document.querySelector("#productdate").value;
		var productlowestprice = document.querySelector("#productlowestprice").value;
		var producthopefulprice = document.querySelector("#producthopefulprice").value;
		//var productimage = document.querySelector("#productimage").value;
		var productdesc = document.querySelector("#productdesc").value;
		var productbrand = document.querySelector("#productbrand").value;
		var productcondition = document.querySelector("#productcondition").value;
		var params = {productname:productname, productcategory:productcategory, productcode:productcode, productquantity:productquantity,
				productdate:productdate, productlowestprice:productlowestprice,producthopefulprice:producthopefulprice,productimage:productimage,
				productdesc:productdesc,productbrand:productbrand,productcondition:productcondition};
		params = JSON.stringify(params);
		 */
		/* var au = new AjaxUtil( {
			url : '/ATProductInfo/insertATProductInfo',
			method: 'post',
			param : params,
			success : function(res){
	          
			}
		}); 
		
		
	} */
		//업로드 start
		document.querySelector("button[name=ATProductInfo]").onclick = function(){
			var form = document.querySelector("form");
			var formData = new FormData(this.form);
			var url = "/uploadproduct";
			var method = "POST";

			var xhr = new XMLHttpRequest();
			
			xhr.onreadystatechange = function(){
				
			}
			
			xhr.open(method,url);
			xhr.send(formData);
		}
		//업로드 end

		</script>
</body>
</html>