package com.wantdo.service;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.FlowSource;
import com.wantdo.pojo.TimeSale;

public interface ITimeSaleService {
	public List findAll();
	
	public abstract void save(TimeSale xiaoliang);
	
	public List<TimeSale> getData(String json);

	public List<TimeSale> findbyTimeAndName(String times,String shopName,Date saleTime);

	public List<TimeSale> getByOpDate(String startTime, String endTime) throws Exception;

	public void update(TimeSale ts);

}
