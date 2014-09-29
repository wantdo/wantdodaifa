package com.wantdo.service;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Flow;

public interface IFlowService {
	public List findAll();
	
	public abstract void save(Flow flow);
	
	public List<Flow> getData(String json);
	
	public List<Flow> findbyTimeAndNameV(Date flowTime,String shopName,String version);
	
	public List<Flow> findbyTimeAndName(Date flowTime,String shopName);
	
	public void update(Flow flow);

	public List<Flow> getByOpDate(String startTime, String endTime) throws Exception;

}
