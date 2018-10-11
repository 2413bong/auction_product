package com.auction.product.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.auction.product.dao.ATProductDAO;
import com.auction.product.vo.ATProductInfo;

@Repository
public class ATProductDAOImpl implements ATProductDAO{
    
	
	@Autowired
	private SqlSessionTemplate SqlSessionTemplate;
	
	
	@Override
	public List<ATProductInfo> getATProductInfoList(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectList("SQL.ATProductInfo.selectATProductInfo", ATProductInfo);
	}

	@Override
	public int insertATProductInfo(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.insert("SQL.ATProductInfo.insertATProductInfo", ATProductInfo);
	}

	@Override
	public int deleteATProductInfo(int ProductNumber) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.delete("SQL.ATProductInfo.deleteATProductInfo", ProductNumber);
	}

	@Override
	public int updateATProductInfo(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.update("SQL.ATProductInfo.updateATProductInfo", ATProductInfo);
	}

	@Override
	public ATProductInfo getATProductInfoList(Integer ProductNumber) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectOne("SQL.ATProductInfo.selectATProductInfo", ProductNumber);
	}

}
