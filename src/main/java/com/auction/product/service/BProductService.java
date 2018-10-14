package com.auction.product.service;

import java.util.List;

import com.auction.product.vo.ATProductInfo;

public interface BProductService {

	public List<ATProductInfo> getBProductList(ATProductInfo ATProductInfo);
	public ATProductInfo getBProductInfo(int ProductNumber);
	public int insertBProduct(ATProductInfo ATProductInfo);
	public int deleteBProduct(int ProductNumber);
	public int updateBProduct(ATProductInfo ATProductInfo);
}
