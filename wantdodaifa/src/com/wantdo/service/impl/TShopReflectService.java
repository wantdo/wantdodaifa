package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.impl.TShopReflectDAO;
import com.wantdo.pojo.TShopReflect;
import com.wantdo.service.ITShopReflectService;

public class TShopReflectService implements ITShopReflectService{
	private TShopReflectDAO tShopReflectDAO;

	@Override
	public List<TShopReflect> getData(String json) {
		// TODO Auto-generated method stub
		return tShopReflectDAO.getData(json);
	}

	@Override
	public void save(TShopReflect tShopReflect) {
		tShopReflectDAO.save(tShopReflect);
	}

	@Override
	public List findAll() {
		return tShopReflectDAO.findAll();
	}

	@Override
	public void update(TShopReflect tShopReflect) {
		tShopReflectDAO.update(tShopReflect);
		
	}

	public TShopReflectDAO gettShopReflectDAO() {
		return tShopReflectDAO;
	}

	public void settShopReflectDAO(TShopReflectDAO tShopReflectDAO) {
		this.tShopReflectDAO = tShopReflectDAO;
	}

	@Override
	public void delete(TShopReflect reflectDetail) {
		tShopReflectDAO.delete(reflectDetail);
		
	}

	@Override
	public TShopReflect findById(Integer id) {
		return tShopReflectDAO.findById(id);
	}

}
