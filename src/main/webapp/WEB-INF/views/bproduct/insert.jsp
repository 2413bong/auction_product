<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		
	<h3>제품 등록 란</h3>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">제품 수정</h1>
		<h2 class="sub-header">바로 입력하고 수정하면됨</h2>
		
		<form id="myform" enctype="multipart/form-data" method="POST"> 
		<table border="1">
		
			<tr>
			<td align="center">제품 명</td><td align="center"><input type="text" id="productName" name="productName" placeholder="제품명을 입력해 주세요" data-vc="2,30"></td>
			</tr>
			<tr>
			<td align="center">제품 코드</td><td align="center"><input type="text" id="productCode" name="productCode" placeholder="제품코드" data-vc="3,10"> </td>
			</tr>
			<tr>
			<td align="center">제품 수량</td><td align="center"><input type="text" id="productQuantity" name="productQuantity" placeholder="판매 수량 (숫자)" data-vc="1,1000" required > </td>
			</tr>
			<tr>
			<td align="center">제품 최저가</td><td align="center"><input type="text" id="productLowestPrice" name="productLowestPrice" placeholder="제품의 최저가" data-vc="1,1000000000"> </td>
			</tr>
			<tr>
			<td align="center">제품 희망가</td><td align="center"><input type="text" id="productHopefulPrice" name="productHopefulPrice" placeholder="제품 희망가(즉시 구매가)" data-vc="1,1000000000"> </td>
			</tr>
			<tr>
			<td align="center">제품 설명</td><td align="center"><input type="text" id="productDesc" name="productDesc" placeholder="제품의 설명" data-vc="1,300"> </td>
			</tr>
			<tr>
			<td align="center">제품 브랜드</td><td align="center"><input type="text" id="productBrand" name="productBrand" placeholder="제품명의 브랜드" data-vc="1,20"></td>
			</tr>
			<tr>
			<td align="center">제품 상태 </td><td align="center"><input type="text" id="productCondition" name="productCondition" placeholder="제품의 상태(자세히)" data-vc="1,30"> </td>
			</tr>
			<tr>
			<td align="center">제품 분류</td><td align="center"><select id="productCategory" name="productCategory" >
				<option value="austdalia">의류</option>
				<option value="canada">가전제품</option>
				<option value="usa">뭐가 있을까</option>
					</select></td>
			</tr>
			<tr>
			<td colspan="2" align="center">제품사진 선택</td>
			</tr>
			<tr>
			<td colspan="2"><input type="file" name="productImage"></td>
			</tr>
			<tr>
			<td colspan="2"  align="center"><button type="button" name="ATProductInfo" onclick="insert()">업로드하기</button></td>
			</tr>
			<tr>
			</table>
			<img src="" id="preview">
			<input type="file" accept="image/*" >

		</form>
	</div>
	</div>
	</div>

<script>

var fileInput = document.querySelector('input[type="file"]');
var preview = document.getElementById('preview');
 
fileInput.addEventListener('change', function(e) {
    var url = URL.createObjectURL(e.target.files[0]);  
    preview.setAttribute('src', url);
});
function imgvali(){
	var img = document.querySelector('input[type="file"]');

	img= img.value.substring(img.value.lastIndexOf('.')+1);
	if(img.toUpperCase()!='JPG' && img.toUpperCase()!='PNG'){
		alert("jpg 나 png파일을 넣어주세요");
		return false;
	}
	return true;
}

	function insert(){
	var form = document.querySelector('#myform');
	var formData = new FormData(form);
	
	if(valicheck() ){
		if(imgvali()){
			
		
		$.ajax({
			url : '/BProductInfo',
			contentType : false,//헤더 지우기
			processData : false,//쿼리스트링 형식으로 바꾸지 않기
			data : formData,
			type : 'POST',
			success : function(){
				location.href = '/url/bproduct:list';
				alert('성공');
			}
		});
		}
	}
}
	
</script>
</html>