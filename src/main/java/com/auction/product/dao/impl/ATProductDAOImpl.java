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
		return SqlSessionTemplate.selectList("SQL.LEVELINFO.selectLevelInfo", ATProductInfo);
	}

	@Override
	public int insertATProductInfo(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.insert("SQL.LEVELINFO.insertLevelInfo", ATProductInfo);
	}

	@Override
	public int deleteATProductInfo(int ProductNumber) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.delete("SQL.LEVELINFO.deleteLevelInfo", ProductNumber);
	}

	@Override
	public int updateATProductInfo(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.update("SQL.LEVELINFO.updateLevelInfo", ATProductInfo);
	}

	@Override
	public ATProductInfo getATProductInfoList(Integer ProductNumber) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectOne("SQL.LEVELINFO.selectLevelInfo", ProductNumber);
	}

}
