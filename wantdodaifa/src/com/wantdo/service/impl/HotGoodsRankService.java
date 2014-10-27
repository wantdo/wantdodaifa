package com.wantdo.service.impl;

import java.util.Date;
import java.util.List;

import com.wantdo.dao.IHotGoodsRankDAO;
import com.wantdo.pojo.HotGoodsRank;
import com.wantdo.service.IHotGoodsRankService;

public class HotGoodsRankService implements IHotGoodsRankService {
	
	private IHotGoodsRankDAO hotGoodsRankDAO;
	
	

	public IHotGoodsRankDAO getHotGoodsRankDAO() {
		return hotGoodsRankDAO;
	}

	public void setHotGoodsRankDAO(IHotGoodsRankDAO hotGoodsRankDAO) {
		this.hotGoodsRankDAO = hotGoodsRankDAO;
	}

	@Override
	public List<HotGoodsRank> getData(String json) {
		return hotGoodsRankDAO.getData(json);
	}

	@Override
	public void save(HotGoodsRank hotGoodsRank) {
		hotGoodsRankDAO.save(hotGoodsRank);
		
	}

	@Override
	public void update(HotGoodsRank hotGoodsRank) {
		hotGoodsRankDAO.update(hotGoodsRank);
		
	}

	@Override
	public List<HotGoodsRank> findbyTimeAndName(String goodsName,
			Date captureDate, String shopName, String flowSource, String avgVisitNum, String bounceRate) {
		// TODO Auto-generated method stub
		return hotGoodsRankDAO.findbyTimeAndName(goodsName, captureDate, shopName, flowSource, avgVisitNum, bounceRate);
	}

	@Override
	public List<HotGoodsRank> findbyURL(String goodsUrl, Date captureDate) {
		// TODO Auto-generated method stub
		return hotGoodsRankDAO.findbyURL(goodsUrl, captureDate);
	}

}
