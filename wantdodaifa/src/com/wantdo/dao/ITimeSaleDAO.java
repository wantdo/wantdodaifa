package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.TimeSale;

public interface ITimeSaleDAO {
	List<TimeSale> getData(String json);
	
	public void save(TimeSale timeSale);
	
	public List findAll();

	public List<TimeSale> findbyTimeAndName(String times,String shopName,Date saleTime);

	public List<TimeSale> getByOpDate(String startTime, String endTime) throws Exception;

	public void update(TimeSale ts);
}
