package com.wantdo.service.impl;

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
	public List<FlowSource> getSale(String json) {
		// TODO Auto-generated method stub
		return flowSourceDAO.getSale(json);
	}

	public IFlowSourceDAO getFlowSourceDAO() {
		return flowSourceDAO;
	}

	public void setFlowSourceDAO(IFlowSourceDAO flowSourceDAO) {
		this.flowSourceDAO = flowSourceDAO;
	}

}
