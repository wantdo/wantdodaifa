package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.FlowSource;

public interface IFlowSourceDAO {
	List<FlowSource> getSale(String json);
	
	public void save(FlowSource flowSource);
	
	public List findAll();

}
