package com.auction.product.dao;

import java.util.List;

import com.auction.product.vo.ATProductInfo;

public interface ATProductDAO {

	public List<ATProductInfo> getATProductInfoList(ATProductInfo ATProductInfo);
	public int insertATProductInfo(ATProductInfo ATProductInfo);
	public int deleteATProductInfo(int ProductNumber);
	public int updateATProductInfo(ATProductInfo ATProductInfo);
	public ATProductInfo getATProductInfoList(Integer ProductNumber);
}
