package com.wantdo.service.impl;

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
	public List<Flow> getSale(String json) {
		// TODO Auto-generated method stub
		return flowDAO.getSale(json);
	}

	public IFlowDAO getFlowDAO() {
		return flowDAO;
	}

	public void setFlowDAO(IFlowDAO flowDAO) {
		this.flowDAO = flowDAO;
	}

}
