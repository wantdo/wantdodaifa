package com.wantdo.service;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.OrderSale;
import com.wantdo.pojo.Sale;

public interface IOrderSaleService {
	
	public List<OrderSale> getData(String json);
	
	public void save(OrderSale OrderSale);

	public List<OrderSale> findbyTimeAndName(Date saleTime,String shopName);
	
	public List<OrderSale> findbyTimeAndNameAndClient(Date saleTime,
			String shopName);
	
	public void update(OrderSale OrderSale);

	public List<OrderSale> findbyOrderNo(String orderNo);
	
}
