package com.wantdo.service;

import java.util.List;

import com.wantdo.pojo.Sale;

public interface ISaleService {
	public List findAll();
	
	public abstract void save(Sale xiaoliang);
	
	public List<Sale> getSale(String json);
}
