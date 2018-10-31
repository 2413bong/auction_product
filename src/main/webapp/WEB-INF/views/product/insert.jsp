
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<c:if test="${!empty iCnt}">
	<c:if test="${iCnt eq 1}">
		<script>
			alert("저장성공");
			location.href="/atproductInfo";
		</script>
	</c:if>
</c:if>


<!--   -->
<style>
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
		

		<form enctype="multipart/form-data" method="POST" id="ProductInsert">
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
			<label for="productLowestPrice">제품 최저가</label> <input type="text"
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
			</select> <br>
			<!-- 11 -->
			<label for="productImage">제품 사진(이미지)</label> <input type="file"
				name="productImage"> <br>
			<button type="button" name="ATProductInfo">업로드하기</button>

		</form>

	</div>

	<script>
	document.querySelector("button[name=ATProductInfo]").onclick = function(){
		var formData = new FormData(this.form);
		
		if(dataValidation()){
		
		$.ajax({
			url : '/ATProductInfo',
			processData : false,
			contentType : false,
			data : formData,
			type : 'POST',
			success : function(){
				location.href = '/ATProductInfo';
				alert('ㄱㄴ?');
			}
		}
		
		});
	}
	    $('#ProductInsert').validate({
	        onfocusout: false,
	        rules: {
	        	productName: {
	                required: true,
	                minlength: 1
	            }, 
	         
	            	productCode: {
		                required: true,
		                minlength: 1
		            }, 
		          
		            	productQuantity: {
			                required: true,
			                minlength: 1
			            }, 
			          
			            	productLowestPrice: {
				                required: true,
				                minlength: 1
				            }, 
				           
				            	productDate: {
					                required: true,
					                minlength: 1
					            }, 
					          
					            	productHopefulPrice: {
						                required: true,
						                minlength: 1
						            }, 
						          
						            	productDesc: {
							                required: true,
							                minlength: 1
							            }, 
							          
							            	productBrand: {
								                required: true,
								                minlength: 1
								            }, 
								           
								            
	            }
	        }, messages: {
	        	productName: {
	                required: "productName을 입력하세요.",
	                minlength: $.validator.format("productName은 최소 {1} 글자 이상 입력하세요.")
	            },
	            productCode: {
	                required: "productCode을 입력하세요.",
	                minlength: $.validator.format("productCode은 최소 {1} 글자 이상 입력하세요.")
	            },
	            productQuantity: {
	                required: "productQuantity을 입력하세요.",
	                minlength: $.validator.format("productQuantity은 최소 {1} 글자 이상 입력하세요.")
	            },
	            productLowestPrice: {
	                required: "productLowestPrice 입력하세요.",
	                minlength: $.validator.format("productLowestPrice은 최소 {1} 글자 이상 입력하세요.")
	            },
	            productDate: {
	                required: "productDate을 입력하세요.",
	                minlength: $.validator.format("productDate최소 {1} 글자 이상 입력하세요.")
	            },
	            productHopefulPrice: {
	                required: "productHopefulPrice을 입력하세요.",
	                minlength: $.validator.format("productHopefulPrice은 최소 {1} 글자 이상 입력하세요.")
	            },
	            productDesc: {
	                required: "productDesc 입력하세요.",
	                minlength: $.validator.format("productDesc은 최소 {1} 글자 이상 입력하세요.")
	            },
	            productBrand: {
	                required: "productBrand을 입력하세요.",
	                minlength: $.validator.format("productBrand은 최소 {1} 글자 이상 입력하세요.")
	            },
	           
	        }, errorPlacement: function (error, element) {
	            // $(element).removeClass('error');
	            // do nothing;
	        }, invalidHandler: function (form, validator) {
	            var errors = validator.numberOfInvalids();
	            if (errors) {
	                alert(validator.errorList[0].message);
	                validator.errorList[0].element.focus();
	            }
	        }, submitHandler: function (form) {
	            $.ajax({
	                type: "POST",
	                url: "/sample/ajax/ajaxJson.do",
	                data: $(form).serialize(),
	                dataType: "json",
	                contentType: "application/x-www-form-urlencoded; charset=utf-8",
	                success: function (data) {
	                    if (data.code == '0') {
	                        alert('code:' + data.code + '\n' + 'msg:' + data.msg);
	                    }
	                }, error: function (jqXHR, textStatus, errorThrown) {
	                    alert(failMsg + ' ' + textStatus.msg);
	                }
	            });
	        }
	  


		</script>
</body>
</html>