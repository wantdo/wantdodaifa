package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.TShopReflect;

public interface ITShopReflectDAO {
	
	List<TShopReflect> getData(String json);
	
	public void save(TShopReflect tShopReflect);
	
	public List findAll();
	
	public void update(TShopReflect tShopReflect);

	public void delete(TShopReflect reflectDetail);

	public TShopReflect findById(Integer id);

}
