<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Dashboard</h1>
				<h2 class="sub-header">Section title</h2>
				<div class="table-responsive">
				<img src="/resources/img/${product.productImage}">
					<form id="iform" enctype="multipart/form-data" method="POST">
					<table class="table table-striped">
                  		<tbody>
							<tr><td>제품번호:   ${product.productNumber}</td></tr>
							<tr><td>제품이름   :<input type="text" value="${product.productName}"></td></tr>
							<tr><td>제품분류   :<input type="text" value="${product.productCategory}"></td></tr>
							<tr><td>제품코드   :<input type="text" value="${product.productCode}"></td></tr>
							<tr><td>제품수량   :<input type="text" value="${product.productQuantity}"></td></tr>
							<tr><td>제품시간   :<input type="text" value="${product.productDate}"></td></tr>
							<tr><td>제품상태   :<input type="text" value="${product.productCondition}"></td></tr>
							<tr><td>브랜드명   :<input type="text" value="${product.productBrand}"></td></tr>
							<tr><td>시작가격   :<input type="text" value="${product.productLowestPrice}"></td></tr>
							<tr><td>희망가격   :<input type="text" value="${product.productHopefulPrice}"></td></tr>
							<tr><td>기타사항   :<input type="text" value="${product.productDesc}"></td></tr>
							<tr><td><button type="button" onclick="update(${product.productNumber})">수정</button><button type="button" onclick="delete1(${product.productNumber})">삭제</button></td></tr>
						</tbody>
						</table>
					</form>
				</div>
			</div>
	<script>
		function update(){
		var form = document.querySelector('#iform');
		var formData = new FormData(form);
		if(valicheck() ){
			$.ajax({
				url : '/BProductInfo/'+${product.productNumber},
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
		
	</script>
</body>
</html>