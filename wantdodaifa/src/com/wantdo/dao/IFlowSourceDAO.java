package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.FlowSource;

public interface IFlowSourceDAO {
	List<FlowSource> getData(String json);
	
	public void save(FlowSource flowSource);
	
	public List findAll();
	
	public List findByExample(FlowSource flowSourceList);

	public List<FlowSource> findbyTimeAndName(Date flowSourceTime,String shopName,String flowSource);

	public List<FlowSource> getByOpDate(String startTime, String endTime) throws Exception;

}
