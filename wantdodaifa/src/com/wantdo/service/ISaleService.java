package com.wantdo.service;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Sale;

public interface ISaleService {
	public List findAll();
	
	public abstract void save(Sale xiaoliang);
	
	public List<Sale> getData(String json);
	
	public void update(Sale sale);
	
	public List<Sale> findbyTimeAndName(Date saleTime,String shopName);

	public List<Sale> getByOpDate(String startTime, String endTime) throws Exception;

	public List getByOpDayDate(String startTime, String endTime) throws Exception;
}
