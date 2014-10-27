package com.wantdo.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alibaba.fastjson.JSON;
import com.wantdo.dao.IHotGoodsRankDAO;
import com.wantdo.pojo.HotGoodsRank;

/**
 * A data access object (DAO) providing persistence and search support for
 * HotGoodsRank entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.pojo.HotGoodsRank
 * @author MyEclipse Persistence Tools
 */
public class HotGoodsRankDAO extends HibernateDaoSupport implements IHotGoodsRankDAO{
	private static final Logger log = LoggerFactory
			.getLogger(HotGoodsRankDAO.class);
	// property constants
	public static final String RANK = "rank";
	public static final String GOODS_NAME = "goodsName";
	public static final String PRICE = "price";
	public static final String DEAL_GOODS_INDEX = "dealGoodsIndex";
	public static final String LINK_CHANGE_RATE = "linkChangeRate";
	public static final String FLOW_SOURCE = "flowSource";
	public static final String PVIEWS = "pviews";
	public static final String PVISITS = "pvisits";
	public static final String AVG_VISIT_NUM = "avgVisitNum";
	public static final String BOUNCE_RATE = "bounceRate";
	public static final String GOODS_URL = "goodsUrl";
	public static final String SHOP_NAME = "shopName";
	public static final String SIGN = "sign";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(HotGoodsRank transientInstance) {
		log.debug("saving HotGoodsRank instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HotGoodsRank persistentInstance) {
		log.debug("deleting HotGoodsRank instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HotGoodsRank findById(java.lang.Integer id) {
		log.debug("getting HotGoodsRank instance with id: " + id);
		try {
			HotGoodsRank instance = (HotGoodsRank) getHibernateTemplate().get(
					"com.wantdo.pojo.HotGoodsRank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HotGoodsRank instance) {
		log.debug("finding HotGoodsRank instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding HotGoodsRank instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HotGoodsRank as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRank(Object rank) {
		return findByProperty(RANK, rank);
	}

	public List findByGoodsName(Object goodsName) {
		return findByProperty(GOODS_NAME, goodsName);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByDealGoodsIndex(Object dealGoodsIndex) {
		return findByProperty(DEAL_GOODS_INDEX, dealGoodsIndex);
	}

	public List findByLinkChangeRate(Object linkChangeRate) {
		return findByProperty(LINK_CHANGE_RATE, linkChangeRate);
	}

	public List findByFlowSource(Object flowSource) {
		return findByProperty(FLOW_SOURCE, flowSource);
	}

	public List findByPviews(Object pviews) {
		return findByProperty(PVIEWS, pviews);
	}

	public List findByPvisits(Object pvisits) {
		return findByProperty(PVISITS, pvisits);
	}

	public List findByAvgVisitNum(Object avgVisitNum) {
		return findByProperty(AVG_VISIT_NUM, avgVisitNum);
	}

	public List findByBounceRate(Object bounceRate) {
		return findByProperty(BOUNCE_RATE, bounceRate);
	}

	public List findByGoodsUrl(Object goodsUrl) {
		return findByProperty(GOODS_URL, goodsUrl);
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findBysign(Object sign) {
		return findByProperty(SIGN, sign);
	}

	public List findByversion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		log.debug("finding all HotGoodsRank instances");
		try {
			String queryString = "from HotGoodsRank";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HotGoodsRank merge(HotGoodsRank detachedInstance) {
		log.debug("merging HotGoodsRank instance");
		try {
			HotGoodsRank result = (HotGoodsRank) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HotGoodsRank instance) {
		log.debug("attaching dirty HotGoodsRank instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HotGoodsRank instance) {
		log.debug("attaching clean HotGoodsRank instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HotGoodsRankDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (HotGoodsRankDAO) ctx.getBean("HotGoodsRankDAO");
	}

	@Override
	public List<HotGoodsRank> getData(String json) {
		List<HotGoodsRank> hotGoodsRank = JSON.parseArray(json, HotGoodsRank.class);
		return hotGoodsRank;
	}

	@Override
	public void update(HotGoodsRank hotGoodsRank) {
		log.debug("updating HotGoodsRank instance");
        try {
            getHibernateTemplate().update(hotGoodsRank);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
		
	}

	@Override
	public List<HotGoodsRank> findbyTimeAndName(String goodsName,
			Date captureDate, String shopName, String flowSource, String avgVisitNum, String bounceRate) {
		log.debug("finding all HotGoodsRank instances");
		try {
			String queryString = "from HotGoodsRank as h where h.goodsName=? and h.captureDate=? and h.shopName=? and h.flowSource=? and h.avgVisitNum=? and h.bounceRate=?";
			return getHibernateTemplate().find(queryString,new Object[]{goodsName,captureDate, shopName, flowSource, avgVisitNum, bounceRate});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<HotGoodsRank> findbyURL(String goodsUrl,Date captureDate) {
		log.debug("finding all HotGoodsRank instances");
		try {
			String queryString = "from HotGoodsRank as h where h.goodsUrl=? and h.captureDate=?";
			return getHibernateTemplate().find(queryString,new Object[]{goodsUrl,captureDate});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

}