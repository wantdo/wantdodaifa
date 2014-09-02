package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ISaleDAO;
import com.wantdo.pojo.Sale;
import com.wantdo.service.ISaleService;

public class SaleService implements ISaleService{
	private ISaleDAO saleDAO;

	@Override
	public void save(Sale xiaoliang) {
		// TODO Auto-generated method stub
		saleDAO.save(xiaoliang);
	}

	public ISaleDAO getSaleDAO() {
		return saleDAO;
	}

	public void setSaleDAO(ISaleDAO saleDAO) {
		this.saleDAO = saleDAO;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return saleDAO.findAll();
	}

	@Override
	public List<Sale> getSale(String json) {
		// TODO Auto-generated method stub
		return saleDAO.getSale(json);
	}
}
