package com.wantdo.service;

import java.util.List;

public interface IWspShopsService {
	//��ѯ����ERP�������������wantdo������Ϣ
	public List findAll();
	//��ѯָ��ID��ERP�������������wantdo������Ϣ
	public List findById(Integer wspid);
	
}
