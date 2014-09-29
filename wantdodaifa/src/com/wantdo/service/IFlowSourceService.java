package com.wantdo.service;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.FlowSource;

public interface IFlowSourceService {
	public List findAll();
	
	public List findByExample(FlowSource flowSourceList);
	
	public abstract void save(FlowSource flowSource);
	
	public List<FlowSource> getData(String json);

	public List<FlowSource> findbyTimeAndName(Date strDate,String shopName,String flowSource);

	public List<FlowSource> getByOpDate(String startTime, String endTime) throws Exception;

}
