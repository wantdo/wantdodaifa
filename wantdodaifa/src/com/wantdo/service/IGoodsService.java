package com.wantdo.service;

import java.util.List;

import com.wantdo.pojo.Goods;

public interface IGoodsService {
	public List findAll();
	
	public abstract void save(Goods goods);
	
	public List<Goods> getSale(String json);

}
