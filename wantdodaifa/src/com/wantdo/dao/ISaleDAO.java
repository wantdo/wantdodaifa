package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.Sale;

public interface ISaleDAO {
	
	List<Sale> getSale(String json);
	
	public void save(Sale sale);
	
	public List findAll();
}
