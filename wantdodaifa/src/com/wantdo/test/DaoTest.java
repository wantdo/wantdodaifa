package com.wantdo.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.wantdo.dao.ISaleDAO;
import com.wantdo.pojo.Sale;

public class DaoTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ISaleDAO dao=(ISaleDAO)factory.getBean("SaleDAO");
		List<Sale> list=dao.findAll();
			System.out.println(list.size());
	}
	

}
