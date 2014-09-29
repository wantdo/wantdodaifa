package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.OrderJd;

public interface IOrderJdDAO {
	List<OrderJd> getData(String json);
	
	public void save(OrderJd orderJd);
	
	public List findAll();

}
