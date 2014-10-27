package com.wantdo.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wantdo.dao.impl.HotGoodsRankDAO;
import com.wantdo.dao.impl.SaleDAO;
import com.wantdo.pojo.HotGoodsRank;

public class DaoTest {

	@Test
	public void testfindbyURL() {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		HotGoodsRankDAO dao=(HotGoodsRankDAO)context.getBean("HotGoodsRankDAO");
		String goodsURL="http://item.jd.com/1309484170.html";
		Date captureDate=new Date();
		List<HotGoodsRank> hotGoodsRanks=dao.findbyURL(goodsURL, captureDate);
		System.out.println(hotGoodsRanks);
	}
	
	@Test
	public void testgetByOpDate() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		SaleDAO dao=(SaleDAO)context.getBean("SaleDAO");
		String startTime="2014-10-19";
		String endTime="2014-10-22";
		List list=dao.getByOpDate(startTime, endTime);
		System.out.println(list);
	}

}
