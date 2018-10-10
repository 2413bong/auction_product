package com.auction.product.vo;

import org.apache.ibatis.type.Alias;

@Alias("product")
public class ATProductInfo {
	private Integer productNumber;
	private String productName;
	private String productCategory;
	private String productCode;
	private Integer productQuantity;
	private String productDate;
	private Integer productLowestPrice;
	private Integer productHopefulPrice;
	private String productImage;
	private String productDesc;
	private String productBrand;
	private String productCondition;

	public ATProductInfo() {
	}

	@Override
	public String toString() {
		return "ATProductInfo [productNumber=" + productNumber + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productCode=" + productCode + ", productQuantity=" + productQuantity
				+ ", productDate=" + productDate + ", productLowestPrice=" + productLowestPrice
				+ ", productHopefulPrice=" + productHopefulPrice + ", productImage=" + productImage + ", productDesc="
				+ productDesc + ", productBrand=" + productBrand + ", productCondition=" + productCondition + "]";
	}

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public Integer getProductLowestPrice() {
		return productLowestPrice;
	}

	public void setProductLowestPrice(Integer productLowestPrice) {
		this.productLowestPrice = productLowestPrice;
	}

	public Integer getProductHopefulPrice() {
		return productHopefulPrice;
	}

	public void setProductHopefulPrice(Integer productHopefulPrice) {
		this.productHopefulPrice = productHopefulPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}

	public ATProductInfo(Integer productNumber, String productName, String productCategory, String productCode,
			Integer productQuantity, String productDate, Integer productLowestPrice, Integer productHopefulPrice,
			String productImage, String productDesc, String productBrand, String productCondition) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productCode = productCode;
		this.productQuantity = productQuantity;
		this.productDate = productDate;
		this.productLowestPrice = productLowestPrice;
		this.productHopefulPrice = productHopefulPrice;
		this.productImage = productImage;
		this.productDesc = productDesc;
		this.productBrand = productBrand;
		this.productCondition = productCondition;
	}

}
