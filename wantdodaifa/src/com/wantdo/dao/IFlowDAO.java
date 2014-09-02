package com.wantdo.dao;

import java.util.List;

import com.wantdo.pojo.Flow;

public interface IFlowDAO {
	List<Flow> getSale(String json);
	
	public void save(Flow flow);
	
	public List findAll();

}
