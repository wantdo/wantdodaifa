package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IOrderJdDAO;
import com.wantdo.pojo.OrderJd;
import com.wantdo.service.IOrderJdService;

public class OrderJdService implements IOrderJdService {
	private IOrderJdDAO orderJdDAO;
	

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return orderJdDAO.findAll();
	}

	@Override
	public void save(OrderJd orderJd) {
		// TODO Auto-generated method stub
		orderJdDAO.save(orderJd);
	}

	@Override
	public List<OrderJd> getSale(String json) {
		// TODO Auto-generated method stub
		return orderJdDAO.getSale(json);
	}
	
	
	public IOrderJdDAO getOrderJdDAO() {
		return orderJdDAO;
	}
	
	public void setOrderJdDAO(IOrderJdDAO orderJdDAO) {
		this.orderJdDAO = orderJdDAO;
	}

}
