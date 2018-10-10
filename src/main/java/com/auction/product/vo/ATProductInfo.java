package com.auction.product.vo;

import org.apache.ibatis.type.Alias;

@Alias("Product")
public class ATProductInfo {
	private Integer ProductNumber;
	private String ProductName;
	private String ProductCategory;
	private String ProductCode;
	private Integer ProductQuantity;
	private String ProductDate;
	private Integer ProductLowestPrice;
	private Integer ProductHopefulPrice;
	private String ProductImage;
	private String ProductDesc;
	private String ProductBrand;
	private String ProductCondition;
	
	public ATProductInfo() {}
  
	public ATProductInfo(Integer productNumber, String productName, String productCategory, String productCode,
			Integer productQuantity, String productDate, Integer productLowestPrice, Integer productHopefulPrice,
			String productImage, String productDesc, String productBrand, String productCondition) {
		super();
		ProductNumber = productNumber;
		ProductName = productName;
		ProductCategory = productCategory;
		ProductCode = productCode;
		ProductQuantity = productQuantity;
		ProductDate = productDate;
		ProductLowestPrice = productLowestPrice;
		ProductHopefulPrice = productHopefulPrice;
		ProductImage = productImage;
		ProductDesc = productDesc;
		ProductBrand = productBrand;
		ProductCondition = productCondition;
	}

	public Integer getProductNumber() {
		return ProductNumber;
	}

	public void setProductNumber(Integer productNumber) {
		ProductNumber = productNumber;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getProductCategory() {
		return ProductCategory;
	}

	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}

	public String getProductCode() {
		return ProductCode;
	}

	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}

	public Integer getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		ProductQuantity = productQuantity;
	}

	public String getProductDate() {
		return ProductDate;
	}

	public void setProductDate(String productDate) {
		ProductDate = productDate;
	}

	public Integer getProductLowestPrice() {
		return ProductLowestPrice;
	}

	public void setProductLowestPrice(Integer productLowestPrice) {
		ProductLowestPrice = productLowestPrice;
	}

	public Integer getProductHopefulPrice() {
		return ProductHopefulPrice;
	}

	public void setProductHopefulPrice(Integer productHopefulPrice) {
		ProductHopefulPrice = productHopefulPrice;
	}

	public String getProductImage() {
		return ProductImage;
	}

	public void setProductImage(String productImage) {
		ProductImage = productImage;
	}

	public String getProductDesc() {
		return ProductDesc;
	}

	public void setProductDesc(String productDesc) {
		ProductDesc = productDesc;
	}

	public String getProductBrand() {
		return ProductBrand;
	}

	public void setProductBrand(String productBrand) {
		ProductBrand = productBrand;
	}

	public String getProductCondition() {
		return ProductCondition;
	}

	public void setProductCondition(String productCondition) {
		ProductCondition = productCondition;
	}

	@Override
	public String toString() {
		return "ATProductInfo [ProductNumber=" + ProductNumber + ", ProductName=" + ProductName + ", ProductCategory="
				+ ProductCategory + ", ProductCode=" + ProductCode + ", ProductQuantity=" + ProductQuantity
				+ ", ProductDate=" + ProductDate + ", ProductLowestPrice=" + ProductLowestPrice
				+ ", ProductHopefulPrice=" + ProductHopefulPrice + ", ProductImage=" + ProductImage + ", ProductDesc="
				+ ProductDesc + ", ProductBrand=" + ProductBrand + ", ProductCondition=" + ProductCondition + "]";
	}

}
