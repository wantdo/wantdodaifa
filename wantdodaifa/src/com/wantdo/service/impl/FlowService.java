package com.wantdo.service.impl;

import java.util.Date;
import java.util.List;

import com.wantdo.dao.IFlowDAO;
import com.wantdo.pojo.Flow;
import com.wantdo.service.IFlowService;

public class FlowService implements IFlowService {
	private IFlowDAO flowDAO;

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return flowDAO.findAll();
	}

	@Override
	public void save(Flow flow) {
		// TODO Auto-generated method stub
		flowDAO.save(flow);
	}

	@Override
	public List<Flow> getData(String json) {
		// TODO Auto-generated method stub
		return flowDAO.getData(json);
	}

	public IFlowDAO getFlowDAO() {
		return flowDAO;
	}

	public void setFlowDAO(IFlowDAO flowDAO) {
		this.flowDAO = flowDAO;
	}

	@Override
	public List<Flow> findbyTimeAndNameV(Date flowTime,String shopName,String version) {
		return flowDAO.findbyTimeAndNameV(flowTime, shopName,version);
	}

	@Override
	public void update(Flow flow) {
		// TODO Auto-generated method stub
		flowDAO.update(flow);
	}

	@Override
	public List<Flow> findbyTimeAndName(Date flowTime, String shopName) {
		// TODO Auto-generated method stub
		return flowDAO.findbyTimeAndName(flowTime, shopName);
	}

	@Override
	public List<Flow> getByOpDate(String startTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return flowDAO.getByOpDate(startTime, endTime);
	}
	

}
