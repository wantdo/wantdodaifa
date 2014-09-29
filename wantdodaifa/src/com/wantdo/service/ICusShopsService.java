package com.wantdo.service;

import java.util.List;

import com.wantdo.pojo.CusShops;

public interface ICusShopsService {
	public abstract List findAll();
	
	public void save(CusShops transientInstance);
	
	public void delete(CusShops transientInstance);
	
	public CusShops findById(java.lang.Integer id);
	
	public void update(CusShops updateInstance);
}
