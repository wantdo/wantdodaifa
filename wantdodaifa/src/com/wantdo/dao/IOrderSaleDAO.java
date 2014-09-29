package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.OrderSale;

public interface IOrderSaleDAO {
	
	List<OrderSale> getData(String json);
	
	public void save(OrderSale OrderSale);

	public List<OrderSale> findbyTimeAndName(Date saleTime,String shopName);

	public List<OrderSale> findbyTimeAndNameAndClient(Date saleTime,
			String shopName);
	
}
