package com.wantdo.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.wantdo.pojo.Flow;
import com.wantdo.pojo.HotGoodsRank;

public interface IHotGoodsRankService {
	
	List<HotGoodsRank> getData(String json);
	
	public void save(HotGoodsRank hotGoodsRank);
	
	public void update(HotGoodsRank hotGoodsRank);

	List<HotGoodsRank> findbyTimeAndName(String goodsName, Date captureDate, String shopName, String flowSource, String avgVisitNum, String bounceRate);

	List<HotGoodsRank> findbyURL(String goodsUrl, Date captureDate);


}
