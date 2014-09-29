package com.wantdo.service.impl;

import java.util.Date;
import java.util.List;

import com.wantdo.dao.IFlowSourceDAO;
import com.wantdo.pojo.FlowSource;
import com.wantdo.service.IFlowSourceService;

public class FlowSourceService implements IFlowSourceService {
	private IFlowSourceDAO flowSourceDAO;

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return flowSourceDAO.findAll();
	}

	@Override
	public void save(FlowSource flowSource) {
		// TODO Auto-generated method stub
		flowSourceDAO.save(flowSource);
	}

	@Override
	public List<FlowSource> getData(String json) {
		// TODO Auto-generated method stub
		return flowSourceDAO.getData(json);
	}

	public IFlowSourceDAO getFlowSourceDAO() {
		return flowSourceDAO;
	}

	public void setFlowSourceDAO(IFlowSourceDAO flowSourceDAO) {
		this.flowSourceDAO = flowSourceDAO;
	}

	@Override
	public List<FlowSource> findbyTimeAndName(Date flowSourceTime, String shopName,
			String flowSource) {
		return flowSourceDAO.findbyTimeAndName(flowSourceTime, shopName,flowSource);
	}

	@Override
	public List findByExample(FlowSource flowSourceList) {
		// TODO Auto-generated method stub
		return flowSourceDAO.findByExample(flowSourceList);
	}

	@Override
	public List<FlowSource> getByOpDate(String startTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return flowSourceDAO.getByOpDate(startTime, endTime) ;
	}

}
