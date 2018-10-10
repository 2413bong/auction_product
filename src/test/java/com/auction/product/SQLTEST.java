package com.auction.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auction.product.vo.ATProductInfo;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;



/**
 * @author BaeJinseok
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/root-context.xml")
public class SQLTEST {

	@Autowired
	@Qualifier("dataSourceProxy")//1 @Quaproductfier로 구분짓는다
	private Log4jdbcProxyDataSource ds;//2 @Autowired는 클래스명으로 구분짓는다

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
//
//	@Test
//	public void ssTest() {
//		List<ATProductInfo> liList = ss.selectList("SQL.ATProductInfo.selectATProductInfo");
//		assertEquals(liList.size(), 3);
//	}

	@Test
	public void ssTest() {
		List<ATProductInfo> selectproductList = ss.selectList("SQL.ATProductInfo.selectATProductInfo");
		assertEquals(selectproductList.size(), 0);
	}
//	@Test
//	public void insertTest() {
//		ATProductInfo li = new ATProductInfo();
//		li.setProductNumber(1);
//		li.setProductName("테스트");
//		li.setProductCategory("테스트");
//		li.setProductCode("테스트");
//		li.setProductQuantity(1);
//		li.setProductDate("테스트");
//		li.setProductLowestPrice(1);
//		li.setProductHopefulPrice(5);
//		li.setProductImage("테스트");
//		li.setProductDesc("테스트");
//		li.setProductBrand("테스트");
//		li.setProductCondition("테스트");
//		assertEquals(ss.insert("SQL.ATProductInfo.insertATProductInfo", li), 1);
//	}
	@Test
	public void insertTest() {
		ATProductInfo product = new ATProductInfo();
		product.setProductNumber(1);
		product.setProductName("테스트");
		product.setProductCategory("테스트");
		product.setProductCode("테스트");
		product.setProductQuantity(1);
		product.setProductDate("테스트");
		product.setProductLowestPrice(1);
		product.setProductHopefulPrice(5);
		product.setProductImage("테스트");
		product.setProductDesc("테스트");
		product.setProductBrand("테스트");
		product.setProductCondition("테스트");
		assertEquals(ss.insert("SQL.ATProductInfo.insertATProductInfo", product), 1);
	}
//	@Test
//	public void updateTest() {
//		ATProductInfo li = new ATProductInfo();
//		li.setProductNumber(1);
//		li.setProductName("테스트");
//		li.setProductCategory("테스트");
//		li.setProductCode("테스트");
//		li.setProductQuantity(1);
//		li.setProductDate("테스트");
//		li.setProductLowestPrice(1);
//		li.setProductHopefulPrice(5);
//		li.setProductImage("테스트");
//		li.setProductDesc("테스트");
//		li.setProductBrand("테스트");
//		li.setProductCondition("테스트");
//		assertEquals(ss.update("SQL.ATProductInfo.updateATProductInfo", li), 1);
//	}

/*	@Test
	public void updateTest() {
		ATProductInfo product = new ATProductInfo();
		product.setProductNumber(1);
		product.setProductName("테스트");
		product.setProductCategory("테스트");
		product.setProductCode("테스트");
		product.setProductQuantity(1);
		product.setProductDate("테스트");
		product.setProductLowestPrice(1);
		product.setProductHopefulPrice(5);
		product.setProductImage("테스트");
		product.setProductDesc("테스트");
		product.setProductBrand("테스트");
		product.setProductCondition("테스트");
		assertEquals(ss.update("SQL.ATProductInfo.updateATProductInfo", product), 1);
	}

	@Test
	public void deleteTest() {
		ATProductInfo product = new ATProductInfo();
		product.setProductNumber(1);
		assertEquals(ss.delete("SQL.ATProductInfo.deleteATProductInfo", product), 1);

	}*/
=======
//	@Test
//	public void deleteTest() {
//		ATProductInfo li = new ATProductInfo();
//		li.setProductNumber(1);
//		assertEquals(ss.delete("SQL.ATProductInfo.deleteATProductInfo", li), 1);
//
//	}

}


