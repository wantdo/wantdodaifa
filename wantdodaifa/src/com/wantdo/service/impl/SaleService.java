package com.wantdo.service.impl;

import java.util.Date;
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
	public List<Sale> getData(String json) {
		// TODO Auto-generated method stub
		return saleDAO.getData(json);
	}

	@Override
	public List<Sale> findbyTimeAndName(Date saleTime, String shopName) {
		// TODO Auto-generated method stub
		return saleDAO.findbyTimeAndName(saleTime, shopName);
	}

	@Override
	public List<Sale> getByOpDate(String startTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return saleDAO.getByOpDate(startTime, endTime);
	}

	@Override
	public List getByOpDayDate(String startTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return saleDAO.getByOpDayDate(startTime, endTime);
	}

	@Override
	public void update(Sale sale) {
		saleDAO.update(sale);
		
	}
}
