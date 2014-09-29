package com.wantdo.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alibaba.fastjson.JSON;
import com.wantdo.dao.IFlowDAO;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;

/**
 * A data access object (DAO) providing persistence and search support for Flow
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wantdo.pojo.Flow
 * @author MyEclipse Persistence Tools
 */
public class FlowDAO extends HibernateDaoSupport  implements IFlowDAO{
	private static final Logger log = LoggerFactory.getLogger(FlowDAO.class);
	// property constants
	public static final String PAGEVIEWS = "pageviews";
	public static final String VISITORS = "visitors";
	public static final String VISITS = "visits";
	public static final String AVG_VISIT_DEPTH = "avgVisitDepth";
	public static final String AVG_PACE_TIME = "avgPaceTime";
	public static final String BOUNCE_RATE = "bounceRate";
	public static final String BACK_VISITORS_RATE = "backVisitorsRate";
	public static final String GOODS_VOLUME = "goodsVolume";
	public static final String SHOP_VOLUME = "shopVolume";
	public static final String SHOP_DEAL_RATE = "shopDealRate";
	public static final String FIRST_PAYMENT_RATE = "firstPaymentRate";
	public static final String THIRTY_CUSTOMER_RETENTION = "thirtyCustomerRetention";
	public static final String THIRTY_REPEAT_PURCHASE_RATE = "thirtyRepeatPurchaseRate";
	public static final String SHOP_NAME = "shopName";
	public static final String PLATFORM = "platform";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(Flow transientInstance) {
		log.debug("saving Flow instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Flow persistentInstance) {
		log.debug("deleting Flow instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Flow findById(java.lang.Integer id) {
		log.debug("getting Flow instance with id: " + id);
		try {
			Flow instance = (Flow) getHibernateTemplate().get(
					"com.wantdo.pojo.Flow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Flow instance) {
		log.debug("finding Flow instance by example");
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
		log.debug("finding Flow instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Flow as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPageviews(Object pageviews) {
		return findByProperty(PAGEVIEWS, pageviews);
	}

	public List findByVisitors(Object visitors) {
		return findByProperty(VISITORS, visitors);
	}

	public List findByVisits(Object visits) {
		return findByProperty(VISITS, visits);
	}

	public List findByAvgVisitDepth(Object avgVisitDepth) {
		return findByProperty(AVG_VISIT_DEPTH, avgVisitDepth);
	}

	public List findByAvgPaceTime(Object avgPaceTime) {
		return findByProperty(AVG_PACE_TIME, avgPaceTime);
	}

	public List findByBounceRate(Object bounceRate) {
		return findByProperty(BOUNCE_RATE, bounceRate);
	}

	public List findByBackVisitorsRate(Object backVisitorsRate) {
		return findByProperty(BACK_VISITORS_RATE, backVisitorsRate);
	}

	public List findByGoodsVolume(Object goodsVolume) {
		return findByProperty(GOODS_VOLUME, goodsVolume);
	}

	public List findByShopVolume(Object shopVolume) {
		return findByProperty(SHOP_VOLUME, shopVolume);
	}

	public List findByShopDealRate(Object shopDealRate) {
		return findByProperty(SHOP_DEAL_RATE, shopDealRate);
	}

	public List findByFirstPaymentRate(Object firstPaymentRate) {
		return findByProperty(FIRST_PAYMENT_RATE, firstPaymentRate);
	}

	public List findByThirtyCustomerRetention(Object thirtyCustomerRetention) {
		return findByProperty(THIRTY_CUSTOMER_RETENTION,
				thirtyCustomerRetention);
	}

	public List findByThirtyRepeatPurchaseRate(Object thirtyRepeatPurchaseRate) {
		return findByProperty(THIRTY_REPEAT_PURCHASE_RATE,
				thirtyRepeatPurchaseRate);
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findByPlatform(Object platform) {
		return findByProperty(PLATFORM, platform);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		log.debug("finding all Flow instances");
		try {
			String queryString = "from Flow";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Flow merge(Flow detachedInstance) {
		log.debug("merging Flow instance");
		try {
			Flow result = (Flow) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Flow instance) {
		log.debug("attaching dirty Flow instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Flow instance) {
		log.debug("attaching clean Flow instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FlowDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FlowDAO) ctx.getBean("FlowDAO");
	}
	
	@Override
	public List<Flow> getData(String json) {
		List<Flow> flows = JSON.parseArray(json, Flow.class);
		return flows;
	}

	@Override
	public List<Flow> findbyTimeAndNameV(Date flowTime, String shopName,String version) {
		log.debug("finding all Flow instances");
		try {
			String queryString = "from Flow as f where f.flowTime=? and shopName=? and version=?";
			return getHibernateTemplate().find(queryString,new Object[]{flowTime,shopName,version});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void update(Flow flow) {
        log.debug("updating Flow instance");
        try {
            getHibernateTemplate().update(flow);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

	@Override
	public List<Flow> findbyTimeAndName(Date flowTime, String shopName) {
		log.debug("finding all Flow instances");
		try {
			String queryString = "from Flow as f where f.flowTime=? and shopName=?";
			return getHibernateTemplate().find(queryString,new Object[]{flowTime, shopName});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Flow> getByOpDate(String startTime, String endTime) throws Exception {
		log.debug("finding Flow instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
			String queryString="from Flow as model where model.flowTime " +
					"between ? and ? order by model.flowTime asc";
			return getHibernateTemplate().find(queryString, new Object[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}

}