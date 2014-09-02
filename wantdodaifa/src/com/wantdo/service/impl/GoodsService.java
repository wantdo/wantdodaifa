package com.wantdo.service.impl;

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
	public List<Goods> getSale(String json) {
		// TODO Auto-generated method stub
		return goodsDAO.getSale(json);
	}

	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}

	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}

	
}
