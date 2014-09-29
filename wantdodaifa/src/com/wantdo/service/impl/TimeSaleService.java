package com.wantdo.service.impl;

import java.util.Date;
import java.util.List;

import com.wantdo.dao.ITimeSaleDAO;
import com.wantdo.pojo.TimeSale;
import com.wantdo.service.ITimeSaleService;

public class TimeSaleService implements ITimeSaleService{
	private ITimeSaleDAO timeSaleDAO;

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return timeSaleDAO.findAll();
	}

	@Override
	public void save(TimeSale xiaoliang) {
		// TODO Auto-generated method stub
		timeSaleDAO.save(xiaoliang);
	}

	@Override
	public List<TimeSale> getData(String json) {
		// TODO Auto-generated method stub
		return timeSaleDAO.getData(json);
	}

	public ITimeSaleDAO getTimeSaleDAO() {
		return timeSaleDAO;
	}

	public void setTimeSaleDAO(ITimeSaleDAO timeSaleDAO) {
		this.timeSaleDAO = timeSaleDAO;
	}

	@Override
	public List<TimeSale> findbyTimeAndName(String times, String shopName,
			Date saleTime) {
		// TODO Auto-generated method stub
		return timeSaleDAO.findbyTimeAndName(times, shopName,saleTime);
	}

	@Override
	public List<TimeSale> getByOpDate(String startTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return timeSaleDAO.getByOpDate(startTime, endTime);
	}

}
