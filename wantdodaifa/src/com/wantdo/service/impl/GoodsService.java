package com.wantdo.service.impl;

import java.util.Date;
import java.util.List;

import com.wantdo.dao.IGoodsDAO;
import com.wantdo.pojo.Goods;
import com.wantdo.service.IGoodsService;

public class GoodsService implements IGoodsService {
	private IGoodsDAO goodsDAO;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return goodsDAO.findAll();
	}

	@Override
	public void save(Goods goods) {
		// TODO Auto-generated method stub
		goodsDAO.save(goods);
	}

	@Override
	public List<Goods> getData(String json) {
		// TODO Auto-generated method stub
		return goodsDAO.getData(json);
	}

	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	@Override
	public List<Goods> findbyTimeAndName(Date goodsTime, String shopName) {
		// TODO Auto-generated method stub
		return goodsDAO.findbyTimeAndName(goodsTime, shopName);
	}

	@Override
	public List<Goods> getByOpDate(String startTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return goodsDAO.getByOpDate(startTime, endTime);
	}

	
}
