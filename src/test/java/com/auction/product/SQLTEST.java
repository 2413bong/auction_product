package com.auction.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auction.product.vo.ATProductInfo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SQLTEST {

	@Autowired
	private DataSource ds;

	@Autowired
	private SqlSessionFactory ssf;
	@Autowired
	private SqlSession ss;

	@Test
	public void test() {
		try {
			Connection con = ds.getConnection();
			con = null;
			System.out.println("테스트");
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	public void ssfTest() {
		try (SqlSession ss = ssf.openSession()) {
			System.out.println("Sql Session생성");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void ssTest() {
		List<ATProductInfo> liList = ss.selectList("SQL.ATProductInfo.selectATProductInfo");
		assertEquals(liList.size(), 3);
	}

	@Test
	public void insertTest() {
		ATProductInfo li = new ATProductInfo();
		li.setProductNumber(1);
		li.setProductName("테스트");
		li.setProductCategory("테스트");
		li.setProductCode("테스트");
		li.setProductQuantity(1);
		li.setProductDate("테스트");
		li.setProductLowestPrice(1);
		li.setProductHopefulPrice(5);
		li.setProductImage("테스트");
		li.setProductDesc("테스트");
		li.setProductBrand("테스트");
		li.setProductCondition("테스트");
		assertEquals(ss.insert("SQL.ATProductInfo.insertATProductInfo", li), 1);
	}

	@Test
	public void updateTest() {
		ATProductInfo li = new ATProductInfo();
		li.setProductNumber(1);
		li.setProductName("테스트");
		li.setProductCategory("테스트");
		li.setProductCode("테스트");
		li.setProductQuantity(1);
		li.setProductDate("테스트");
		li.setProductLowestPrice(1);
		li.setProductHopefulPrice(5);
		li.setProductImage("테스트");
		li.setProductDesc("테스트");
		li.setProductBrand("테스트");
		li.setProductCondition("테스트");
		assertEquals(ss.update("SQL.ATProductInfo.updateATProductInfo", li), 1);
	}

	@Test
	public void deleteTest() {
		ATProductInfo li = new ATProductInfo();
		li.setProductNumber(1);
		assertEquals(ss.delete("SQL.ATProductInfo.deleteATProductInfo", li), 1);

	}

}


