package com.wantdo.service;

import java.util.List;

import com.wantdo.pojo.Flow;

public interface IFlowService {
	public List findAll();
	
	public abstract void save(Flow flow);
	
	public List<Flow> getSale(String json);

}
