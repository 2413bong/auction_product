
package com.auction.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auction.product.vo.ATProductInfo;



/**
 * @author BaeJinseok
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/root-context.xml")
public class SQLTEST {


	@Autowired
	private SqlSessionFactory ssf;
	@Autowired
	private SqlSession ss;


	@Test
	public void ssfTest() {
		try (SqlSession ss = ssf.openSession()) {
			System.out.println("Sql Session생성");
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}




	/*@Test
	public void ssTest() {
		List<ATProductInfo> selectproductList = ss.selectList("SQL.ATProductInfo.selectATProductInfo");
		assertEquals(selectproductList.size(), 0);
	}*/
	@Test
	public void insertTest() {
		ATProductInfo li = new ATProductInfo();
		li.setProductNumber(4);
		li.setProductName("테스트14");
		li.setProductCategory("테스트111");
		li.setProductCode("테스트111");
		li.setProductQuantity(1111);
		li.setProductDate("10");
		li.setProductLowestPrice(1111);
		li.setProductHopefulPrice(5111);
		li.setProductImage("테스트111");
		li.setProductDesc("테스트111");
		li.setProductBrand("테스트111");
		li.setProductCondition("테스11트1");
		assertEquals(ss.insert("SQL.ATProductInfo.insertATProductInfo", li), 1);
	}

	
	@Test
	public void updateTest() {
		ATProductInfo ATProductInfo = new ATProductInfo();
		ATProductInfo.setProductNumber(1);
		ATProductInfo.setProductName("테스트");
		ATProductInfo.setProductCategory("테스트");
		ATProductInfo.setProductCode("테스트");
		ATProductInfo.setProductQuantity(1);
		ATProductInfo.setProductDate("테스트");
		ATProductInfo.setProductLowestPrice(1);
		ATProductInfo.setProductHopefulPrice(5);
		ATProductInfo.setProductImage("테스트");
		ATProductInfo.setProductDesc("테스트");
		ATProductInfo.setProductBrand("테스트");
		ATProductInfo.setProductCondition("테스트");
		assertEquals(ss.update("SQL.ATProductInfo.updateATProductInfo", ATProductInfo), 0);
	}


/*	@Test
	public void deleteTest() {
		ATProductInfo product = new ATProductInfo();
		product.setProductNumber(1);
		assertEquals(ss.delete("SQL.ATProductInfo.deleteATProductInfo", product), 1);
	}
*/


}


