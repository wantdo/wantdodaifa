package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusShopsDAO;
import com.wantdo.pojo.CusShops;
import com.wantdo.service.ICusShopsService;

public class CusShopsService implements ICusShopsService {
	private ICusShopsDAO cusShopsDAO;
	@Override
	public List findAll() {
		return cusShopsDAO.findAll();
	}
	@Override
	public void save(CusShops transientInstance) {
		cusShopsDAO.save(transientInstance);
	}
	@Override
	public CusShops findById(Integer id) {
		return cusShopsDAO.findById(id);
	}
	@Override
	public void delete(CusShops transientInstance) {
		cusShopsDAO.delete(transientInstance);
	}
	@Override
	public void update(CusShops updateInstance) {
		cusShopsDAO.update(updateInstance);
	}
	
	
	
	
	public ICusShopsDAO getCusShopsDAO() {
		return cusShopsDAO;
	}
	public void setCusShopsDAO(ICusShopsDAO cusShopsDAO) {
		this.cusShopsDAO = cusShopsDAO;
	}
}
