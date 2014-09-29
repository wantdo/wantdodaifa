package com.wantdo.service;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Goods;

public interface IGoodsService {
	public List findAll();
	
	public abstract void save(Goods goods);
	
	public List<Goods> getData(String json);

	public List<Goods> findbyTimeAndName(Date goodsTime,String shopName);

	public List<Goods> getByOpDate(String startTime, String endTime) throws Exception;
}
