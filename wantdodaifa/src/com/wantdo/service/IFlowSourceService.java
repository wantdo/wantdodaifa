package com.wantdo.service;

import java.util.List;

import com.wantdo.pojo.FlowSource;

public interface IFlowSourceService {
	public List findAll();
	
	public abstract void save(FlowSource flowSource);
	
	public List<FlowSource> getSale(String json);

}
