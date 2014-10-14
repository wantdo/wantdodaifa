package com.wantdo.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alibaba.fastjson.JSON;
import com.wantdo.dao.IFlowSourceDAO;
import com.wantdo.pojo.Flow;
import com.wantdo.pojo.FlowSource;

/**
 * A data access object (DAO) providing persistence and search support for
 * FlowSource entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.pojo.FlowSource
 * @author MyEclipse Persistence Tools
 */
public class FlowSourceDAO extends HibernateDaoSupport  implements IFlowSourceDAO{
	private static final Logger log = LoggerFactory
			.getLogger(FlowSourceDAO.class);
	// property constants
	public static final String FLOW_SOURCE = "flowSource";
	public static final String LAND_PAGE_VIEW = "landPageView";
	public static final String LAND_PAGE_VIEW_ACCOUNTED = "landPageViewAccounted";
	public static final String PAGE_VIEW = "pageView";
	public static final String PAGE_VIEW_ACCOUNTED = "pageViewAccounted";
	public static final String SHOP_NAME = "shopName";
	public static final String PLATFORM = "platform";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(FlowSource transientInstance) {
		log.debug("saving FlowSource instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(FlowSource persistentInstance) {
		log.debug("deleting FlowSource instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FlowSource findById(java.lang.Integer id) {
		log.debug("getting FlowSource instance with id: " + id);
		try {
			FlowSource instance = (FlowSource) getHibernateTemplate().get(
					"com.wantdo.pojo.FlowSource", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FlowSource instance) {
		log.debug("finding FlowSource instance by example");
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
		log.debug("finding FlowSource instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from FlowSource as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFlowSource(Object flowSource) {
		return findByProperty(FLOW_SOURCE, flowSource);
	}

	public List findByLandPageView(Object landPageView) {
		return findByProperty(LAND_PAGE_VIEW, landPageView);
	}

	public List findByLandPageViewAccounted(Object landPageViewAccounted) {
		return findByProperty(LAND_PAGE_VIEW_ACCOUNTED, landPageViewAccounted);
	}

	public List findByPageView(Object pageView) {
		return findByProperty(PAGE_VIEW, pageView);
	}

	public List findByPageViewAccounted(Object pageViewAccounted) {
		return findByProperty(PAGE_VIEW_ACCOUNTED, pageViewAccounted);
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
		log.debug("finding all FlowSource instances");
		try {
			String queryString = "from FlowSource";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public FlowSource merge(FlowSource detachedInstance) {
		log.debug("merging FlowSource instance");
		try {
			FlowSource result = (FlowSource) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(FlowSource instance) {
		log.debug("attaching dirty FlowSource instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FlowSource instance) {
		log.debug("attaching clean FlowSource instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FlowSourceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FlowSourceDAO) ctx.getBean("FlowSourceDAO");
	}
	
	public void update(FlowSource flowSource) {
        log.debug("updating FlowSource instance");
        try {
            getHibernateTemplate().update(flowSource);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
	@Override
	public List<FlowSource> getData(String json) {
		List<FlowSource> flowSources = JSON.parseArray(json, FlowSource.class);
		return flowSources;
	}

	@Override
	public List<FlowSource> findbyTimeAndName(Date flowSourceTime, String shopName,
			String flowSource) {
		log.debug("finding all FlowSource instances");
		try {
			String queryString = "from FlowSource as fs where fs.flowSourceTime=? and shopName=?and flowSource=?";
			return getHibernateTemplate().find(queryString, new Object[]{flowSourceTime, shopName, flowSource});
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<FlowSource> getByOpDate(String startTime, String endTime) throws Exception {
		log.debug("finding FlowSource instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
			String queryString="from FlowSource as model where model.flowSourceTime " +
					"between ? and ? order by model.flowSourceTime asc";
			return getHibernateTemplate().find(queryString, new Object[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}
}