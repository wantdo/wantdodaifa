package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Sale;

public interface ISaleDAO {
	
	List<Sale> getData(String json);
	
	public void save(Sale sale);
	
	public List findAll();
	
	public void update(Sale sale);

	public List<Sale> findbyTimeAndName(Date saleTime,String shopName);

	public List getByOpDate(String startTime, String endTime) throws Exception;

	public List getByOpDayDate(String startTime, String endTime) throws Exception;
}
