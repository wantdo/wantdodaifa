package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.Goods;

public interface IGoodsDAO {
	List<Goods> getSale(String json);
	
	public void save(Goods goods);
	
	public List findAll();

}
