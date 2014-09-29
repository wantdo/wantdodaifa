package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IWspShopsDAO;
import com.wantdo.service.IWspShopsService;

public class WspShopsService implements IWspShopsService {
	private IWspShopsDAO wspShopsDAO;
	@Override
	public List findAll() {
		return wspShopsDAO.findAll();
	}
	@Override
	public List findById(Integer wspid) {
		return wspShopsDAO.findById(wspid);
	}
	
	
	
	public IWspShopsDAO getWspShopsDAO() {
		return wspShopsDAO;
	}
	public void setWspShopsDAO(IWspShopsDAO wspShopsDAO) {
		this.wspShopsDAO = wspShopsDAO;
	}

}
