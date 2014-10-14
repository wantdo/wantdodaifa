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
import com.wantdo.dao.ITimeSaleDAO;
import com.wantdo.pojo.Sale;
import com.wantdo.pojo.TimeSale;

/**
 * A data access object (DAO) providing persistence and search support for
 * TimeSale entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.pojo.TimeSale
 * @author MyEclipse Persistence Tools
 */
public class TimeSaleDAO extends HibernateDaoSupport implements ITimeSaleDAO{
	private static final Logger log = LoggerFactory
			.getLogger(TimeSaleDAO.class);
	// property constants
	public static final String TIMES = "times";
	public static final String PAGEVIEWS = "pageviews";
	public static final String VISITORS = "visitors";
	public static final String VISITS = "visits";
	public static final String SALES = "sales";
	public static final String ORDER_CLIENT_NUM = "orderClientNum";
	public static final String ORDER_QUANTITY = "orderQuantity";
	public static final String ORDER_GOODS_NUM = "orderGoodsNum";
	public static final String SHOP_NAME = "shopName";
	public static final String PLATFORM = "platform";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(TimeSale transientInstance) {
		log.debug("saving TimeSale instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TimeSale persistentInstance) {
		log.debug("deleting TimeSale instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TimeSale findById(java.lang.Integer id) {
		log.debug("getting TimeSale instance with id: " + id);
		try {
			TimeSale instance = (TimeSale) getHibernateTemplate().get(
					"com.wantdo.pojo.TimeSale", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TimeSale instance) {
		log.debug("finding TimeSale instance by example");
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
		log.debug("finding TimeSale instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TimeSale as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTimes(Object times) {
		return findByProperty(TIMES, times);
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

	public List findBySales(Object sales) {
		return findByProperty(SALES, sales);
	}

	public List findByOrderClientNum(Object orderClientNum) {
		return findByProperty(ORDER_CLIENT_NUM, orderClientNum);
	}

	public List findByOrderQuantity(Object orderQuantity) {
		return findByProperty(ORDER_QUANTITY, orderQuantity);
	}

	public List findByOrderGoodsNum(Object orderGoodsNum) {
		return findByProperty(ORDER_GOODS_NUM, orderGoodsNum);
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
		log.debug("finding all TimeSale instances");
		try {
			String queryString = "from TimeSale";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TimeSale merge(TimeSale detachedInstance) {
		log.debug("merging TimeSale instance");
		try {
			TimeSale result = (TimeSale) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TimeSale instance) {
		log.debug("attaching dirty TimeSale instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TimeSale instance) {
		log.debug("attaching clean TimeSale instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TimeSaleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TimeSaleDAO) ctx.getBean("TimeSaleDAO");
	}
	
	@Override
	public void update(TimeSale timeSale) {
        log.debug("updating TimeSale instance");
        try {
            getHibernateTemplate().update(timeSale);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

	@Override
	public List<TimeSale> getData(String json) {
		List<TimeSale> timeSales = JSON.parseArray(json, TimeSale.class);
		return timeSales;
	}

	@Override
	public List<TimeSale> findbyTimeAndName(String times, String shopName,
			Date saleTime) {
		log.debug("finding all TimeSale instances");
		try {
			String queryString = "from TimeSale as ts where ts.times=? and shopName=? and saleTime=?";
			return getHibernateTemplate().find(queryString,new Object[]{times,shopName,saleTime});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<TimeSale> getByOpDate(String startTime, String endTime) throws Exception {
		log.debug("finding TimeSale instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
			String queryString="from TimeSale as model where model.saleTime " +
					"between ? and ? order by model.saleTime asc";
			return getHibernateTemplate().find(queryString, new Object[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}

}