package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.OrderJd;

public interface IOrderJdDAO {
	List<OrderJd> getSale(String json);
	
	public void save(OrderJd orderJd);
	
	public List findAll();

}
