<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
						html += '<td><button type="button" onclick="updateATProductInfo('+ product.productnumber +')">����</button><button type="button" onclick="deleteATProductInfo('+product.productnumber+')">����</button></td>';
						html += '</tr>';
					}
					document.querySelector('#ATProductBody').insertAdjacentHTML('beforeend',html);
			}
		});
		au.send();
	});

</script>
<body>
	�˻� :
	<input type="text" name="ATProductList">
	<button>�˻�</button>
	<table border="1">
		<thead>
			<tr>
				<th>��ǰ ��ȣ</th>
				<th>��ǰ ��</th>
				<th>��ǰ �з�</th>
				<th>��ǰ �ڵ�</th>
				<th>��ǰ ����</th>
				<th>��ǰ �����</th>
				<th>��ǰ ������</th>
				<th>��ǰ �����</th>
				<th>��ǰ �̹���</th>
				<th>��ǰ ����</th>
				<th>��ǰ �귣��</th>
				<th>��ǰ ����</th>
				<th>����/����</th>
			</tr>
		</thead>
		<tbody id="ATProductBody">

		</tbody>
	</table>
	<button onclick="addATProductInfo()">��ǰ �߰�</button>
	<script>
	function addATProductInfo(){
			var html ='<tr>'; 
			html +=	'<td> &nbsp;</td>';
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
			html += '<td><button onclick="saveATProductInfo()">����</button></td>';
			html += '</tr>';
			document.querySelector('ATProductBody').insertAdjacentHTML('beforeend',html);
		}
	function saveATProductInfo(){
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
		var params = {productname:productname, productcategory:productcategory, productcode:productcode, productquantity:productquantity,
				productdate:productdate, productlowestprice:productlowestprice,producthopefulprice:producthopefulprice,productimage:productimage,
				productdesc:productdesc,productbrand:productbrand,productcondition:productcondition};
		params = JSON.stringify(params);
		
		var au = new AjaxUtil( {
			url : '/atproductinfo/',
			method: 'POST',
			param : params,
			success : function(res){
				if(res=='1'){
					alert('����Ϸ�');
					location.href="/url/atproductinfo:list";
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
//				var conf={ �̰� �����͸� �������ִ°�
				url : '/atproductinfo/'+ productnumber,
				method:'DELETE',
				success : function(res){
					if(res=='1'){
						alert('�����Ϸ�');
//						initList();
						locationhref="/url/atproductinfo:list"; //������� ����Ʈ�� �ٽ� ���°�

					}
				}
			});
//			var au = new AjaxUtil( {
			au.send(); 
	}
	</script>
</body>
</html>