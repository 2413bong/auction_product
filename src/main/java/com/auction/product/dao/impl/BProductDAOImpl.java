package com.auction.product.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.auction.product.dao.BProductDAO;
import com.auction.product.vo.ATProductInfo;

@Repository
public class BProductDAOImpl implements BProductDAO {


	@Autowired
	private SqlSessionTemplate SqlSessionTemplate;
	
	@Override
	public List<ATProductInfo> getBProductList(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectList("SQL.BProductSQL.selectList", ATProductInfo);
	}
	@Override
	public ATProductInfo getBProductInfo(int ProductNumber) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.selectOne("SQL.BProductSQL.selectInfo", ProductNumber);
	}

	@Override
	public int insertBProduct(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.insert("SQL.BProductSQL.insert", ATProductInfo);
	}

	@Override
	public int deleteBProduct(int ProductNumber) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.delete("SQL.BProductSQL.delete", ProductNumber);
	}

	@Override
	public int updateBProduct(ATProductInfo ATProductInfo) {
		// TODO Auto-generated method stub
		return SqlSessionTemplate.update("SQL.BProductSQL.update", ATProductInfo);
	}


}
