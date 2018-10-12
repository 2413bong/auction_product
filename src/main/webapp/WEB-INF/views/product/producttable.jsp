
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
</head>
<script>
var AjaxUtil = function(conf){
	var xhr = new XMLHttpRequest(); 
	var url = conf.url;
	var method = conf.method?conf.method:'GET';
	var param = conf.param?conf.param:'{}';
	
	var success= conf.success?conf.success:function(res){
		alert(res);
	}
	var error = conf.error?conf.error:function(res){
		alert(res);
	}
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				success(xhr.responseText);
			}else{
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	if(method!="GET"){
		xhr.setRequestHeader('Content-type','application/json;charset=utf-8');
	}
	this.send=function(){
		xhr.send(param);
	}
}


 
window.addEventListener('load',function(){
		var au = new AjaxUtil( {
			url : '/atproductinfo',
			success : function(res){
				res = JSON.parse(res);
				var html = '';
				
			
					for(var product of res) {
					
						html += '<td>'+product.productnumber+'</td>';
						html += '<td><input type="text" id="productName'+product.productnumber+'" value="' + product.productName + '"></td>';
						html += '<td><input type="text" id="productCategory'+product.productnumber+'" value="' + product.productCategory + '"></td>';
						html += '<td><input type="text" id="productCode'+product.productnumber+'" value="' + product.productCode + '"></td>';
						html += '<td><input type="text" id="productQuantity'+product.productnumber+'" value="' + product.productQuantity + '"></td>';
						html += '<td><input type="text" id="productDate'+product.productnumber+'" value="' + product.productDate + '"></td>';
						html += '<td><input type="text" id="productLowestPrice'+product.productnumber+'" value="' + product.productLowestPrice + '"></td>';
						html += '<td><input type="text" id="productHopefulPrice'+product.productnumber+'" value="' + product.productHopefulPrice + '"></td>';
						html += '<td><input type="text" id="productImage'+product.productnumber+'" value="' + product.productImage + '"></td>';
						html += '<td><input type="text" id="productDesc'+product.productnumber+'" value="' + product.productDesc + '"></td>';
						html += '<td><input type="text" id="productBrand'+product.productnumber+'" value="' + product.productBrand + '"></td>';
						html += '<td><input type="text" id="productCondition'+product.productnumber+'" value="' + product.productCondition + '"></td>';
						html += '<td><button type="button" onclick="updateATProductInfo('+ product.productnumber +')">수정</button><button type="button" onclick="deleteATProductInfo('+product.productnumber+')">삭제</button></td>';
						html += '</tr>';
					}
					document.querySelector('#ATProductBody').insertAdjacentHTML('beforeend',html);
			}
		});
		au.send();
	});

</script>
<body>
	검색 :
	<input type="text" name="ATProductList">
	<button>검색</button>
	<table border="1">
		<thead>
			<tr>
				<th>제품 번호</th>
				<th>제품 명</th>
				<th>제품 분류</th>
				<th>제품 코드</th>
				<th>제품 수량</th>
				<th>제품 등록일</th>
				<th>제품 최저가</th>
				<th>제품 희망가</th>
				<th>제품 이미지</th>
				<th>제품 설명</th>
				<th>제품 브랜드</th>
				<th>제품 상태</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody id="ATProductBody">

		</tbody>
	</table>
	<button  type="button" onclick="location.href='/url/product:insert' "target="_blank">제품 추가</button>
	<script>	
	function addATProductInfo() {
		var html = '<tr>';
		html += '<td> &nbsp;</td>';
		html += '<td><input type="text" id="productName" value=""></td>';
		html += '<td><input type="text" id="productCategory" value=""></td>';
		html += '<td><input type="text" id="productCode" value=""></td>';
		html += '<td><input type="text" id="productQuantity" value=""></td>';
		html += '<td><input type="text" id="productDate" value=""></td>';
		html += '<td><input type="text" id="productLowestPrice" value=""></td>';
		html += '<td><input type="text" id="productHopefulPrice" value=""></td>';
		html += '<td><input type="text" id="productImage" value=""></td>';
		html += '<td><input type="text" id="productDesc" value=""></td>';
		html += '<td><input type="text" id="productBrand" value=""></td>';
		html += '<td><input type="text" id="productCondition" value=""></td>';
		html += '<td><button onclick="saveATProductInfo()">저장</button></td>';
		html += '</tr>';
		document.querySelector('ATProductBody').insertAdjacentHTML('beforeend', html);
	}
	function saveATProductInfo() {
		var productname = document.querySelector("#productname").value;
		var productcategory = document.querySelector("#productcategory").value;
		var productcode = document.querySelector("#productcode").value;
		var productquantity = document.querySelector("#productquantity").value;
		var productdate = document.querySelector("#productdate").value;
		var productlowestprice = document.querySelector("#productlowestprice").value;
		var producthopefulprice = document.querySelector("#producthopefulprice").value;
		var productimage = document.querySelector("#productimage").value;
		var productdesc = document.querySelector("#productdesc").value;
		var productbrand = document.querySelector("#productbrand").value;
		var productcondition = document.querySelector("#productcondition").value;
		var params = {
			productname : productname,
			productcategory : productcategory,
			productcode : productcode,
			productquantity : productquantity,
			productdate : productdate,
			productlowestprice : productlowestprice,
			producthopefulprice : producthopefulprice,
			productimage : productimage,
			productdesc : productdesc,
			productbrand : productbrand,
			productcondition : productcondition
		};
		params = JSON.stringify(params);

		var au = new AjaxUtil({
			url : '/atproductinfo/',
			method : 'POST',
			param : params,
			success : function(res) {
				if (res == '1') {
					alert('저장완료');
					location.href = "/url/atproductinfo:list";
				}
			}
		});
		au.send();
	}
	function updateATProductInfo(productnumber){
		var productname = document.querySelector("#productname" +productnumber).value;
		var productcategory = document.querySelector("#productcategory"+productnumber).value;
		var productcode = document.querySelector("#productcode"+productnumber).value;
		var productquantity = document.querySelector("#productquantity"+productnumber).value;
		var productdate = document.querySelector("#productdate"+productnumber).value;
		var productlowestprice = document.querySelector("#productlowestprice"+productnumber).value;
		var producthopefulprice = document.querySelector("#producthopefulprice"+productnumber).value;
		var productimage = document.querySelector("#productimage"+productnumber).value;
		var productdesc = document.querySelector("#productdesc"+productnumber).value;
		var productbrand = document.querySelector("#productbrand"+productnumber).value;
		var productcondition = document.querySelector("#productcondition"+productnumber).value;
		var params = {productname:productname, productcategory:productcategory, productcode:productcode, productquantity:productquantity,
				productdate:productdate, productlowestprice:productlowestprice,producthopefulprice:producthopefulprice,productimage:productimage,
				productdesc:productdesc,productbrand:productbrand,productcondition:productcondition};
		params = JSON.stringify(params);
		
		var au = new AjaxUtil( {
			url : '/atproductinfo/'+productnumber,
			method: 'PUT',
			param : params,
			success : function(res){
	            alert(res);
			}
		}); 
		au.send();
	}
	function deleteATProductInfo(productnumber){
				
			var au = new AjaxUtil( {
//				var conf={ 이건 데이터만 가져다주는거
				url : '/atproductinfo/'+ productnumber,
				method:'DELETE',
				success : function(res){
					if(res=='1'){
						alert('삭제완료');
//						initList();
						locationhref="/url/atproductinfo:list"; //기존방식 리스트를 다시 들어가는거

					}
				}
			});
//			var au = new AjaxUtil( {
			au.send(); 
	}
	</script>
</body>
</html>