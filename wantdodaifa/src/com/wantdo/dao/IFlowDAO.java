package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Flow;

public interface IFlowDAO {
	List<Flow> getData(String json);
	
	public void save(Flow flow);
	
	public List findAll();
	
	public List<Flow> findbyTimeAndNameV(Date flowTime,String shopName,String version);

	public List<Flow> findbyTimeAndName(Date flowTime,String shopName);
	
	public void update(Flow flow);

	public List<Flow> getByOpDate(String startTime, String endTime) throws Exception;
	
	

}
