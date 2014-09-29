package com.wantdo.service;

import java.util.List;

import com.wantdo.pojo.OrderJd;

public interface IOrderJdService {
	public List findAll();
	
	public abstract void save(OrderJd orderJd);
	
	public List<OrderJd> getData(String json);

}
