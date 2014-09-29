package com.wantdo.dao;

import java.util.List;

public interface IWspShopsDAO {

	public abstract List findById(java.lang.Integer id);

	public abstract List findBySysid(Object sysid);

	public abstract List findByShopname(Object shopname);
	
	public List findAll();
	
}