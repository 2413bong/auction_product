package com.auction.product.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.product.dao.ATProductDAO;
import com.auction.product.service.ATProductService;
import com.auction.product.vo.ATProductInfo;


@Service

public class ATProductServiceImpl implements ATProductService{
    
	@Autowired
	private ATProductDAO ATProductDAO;
	
	@Override
	public List<ATProductInfo> getATProductInfoList(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return ATProductDAO.getATProductInfoList(ATProductInfo);
	}

	@Override
	public int insertATProductInfo(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return ATProductDAO.insertATProductInfo(ATProductInfo);
	}

	@Override
	public int deleteATProductInfo(int ProductNumber) {
		// TODO Auto-generated method stub
		return ATProductDAO.deleteATProductInfo(ProductNumber);
	}

	@Override
	public int updateATProductInfo(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return ATProductDAO.updateATProductInfo(ATProductInfo);
	}

	@Override
	public ATProductInfo getATProductInfoList(Integer ProductNumber) {
		// TODO Auto-generated method stub
		return ATProductDAO.getATProductInfoList(ProductNumber);
	}

}
