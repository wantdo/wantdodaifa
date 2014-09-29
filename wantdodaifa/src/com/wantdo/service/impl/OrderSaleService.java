package com.wantdo.service.impl;

import java.util.Date;
import java.util.List;

import com.wantdo.dao.IOrderSaleDAO;
import com.wantdo.pojo.OrderSale;
import com.wantdo.service.IOrderSaleService;

public class OrderSaleService implements IOrderSaleService{
	private IOrderSaleDAO orderSaleDAO;

	@Override
	public List<OrderSale> getData(String json) {
		// TODO Auto-generated method stub
		return orderSaleDAO.getData(json);
	}

	public IOrderSaleDAO getOrderSaleDAO() {
		return orderSaleDAO;
	}

	public void setOrderSaleDAO(IOrderSaleDAO orderSaleDAO) {
		this.orderSaleDAO = orderSaleDAO;
	}

	@Override
	public void save(OrderSale OrderSale) {
		orderSaleDAO.save(OrderSale);
		
	}

	@Override
	public List<OrderSale> findbyTimeAndName(Date saleTime, String shopName) {
		// TODO Auto-generated method stub
		return orderSaleDAO.findbyTimeAndName(saleTime, shopName);
	}

	@Override
	public List<OrderSale> findbyTimeAndNameAndClient(Date saleTime,
			String shopName) {
		// TODO Auto-generated method stub
		return orderSaleDAO.findbyTimeAndNameAndClient(saleTime, shopName);
	}
	
	
}
