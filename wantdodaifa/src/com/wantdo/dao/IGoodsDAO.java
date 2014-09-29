package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Goods;

public interface IGoodsDAO {
	List<Goods> getData(String json);
	
	public void save(Goods goods);
	
	public List findAll();

	public List<Goods> findbyTimeAndName(Date goodsTime,String shopName);

	public List<Goods> getByOpDate(String startTime, String endTime) throws Exception;
}
