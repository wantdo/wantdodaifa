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
import com.wantdo.dao.IGoodsDAO;
import com.wantdo.pojo.Goods;

/**
 * A data access object (DAO) providing persistence and search support for Goods
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wantdo.pojo.Goods
 * @author MyEclipse Persistence Tools
 */
public class GoodsDAO extends HibernateDaoSupport implements IGoodsDAO{
	private static final Logger log = LoggerFactory.getLogger(GoodsDAO.class);
	// property constants
	public static final String SPU = "spu";
	public static final String SKU = "sku";
	public static final String SHOP_NAME = "shopName";
	public static final String PLATFORM = "platform";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(Goods transientInstance) {
		log.debug("saving Goods instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Goods persistentInstance) {
		log.debug("deleting Goods instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Goods findById(java.lang.Integer id) {
		log.debug("getting Goods instance with id: " + id);
		try {
			Goods instance = (Goods) getHibernateTemplate().get(
					"com.wantdo.pojo.Goods", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Goods instance) {
		log.debug("finding Goods instance by example");
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
		log.debug("finding Goods instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Goods as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySpu(Object spu) {
		return findByProperty(SPU, spu);
	}

	public List findBySku(Object sku) {
		return findByProperty(SKU, sku);
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
		log.debug("finding all Goods instances");
		try {
			String queryString = "from Goods";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Goods merge(Goods detachedInstance) {
		log.debug("merging Goods instance");
		try {
			Goods result = (Goods) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Goods instance) {
		log.debug("attaching dirty Goods instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Goods instance) {
		log.debug("attaching clean Goods instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GoodsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GoodsDAO) ctx.getBean("GoodsDAO");
	}
	
	public void update(GoodsDAO goods) {
        log.debug("updating GoodsDAO instance");
        try {
            getHibernateTemplate().update(goods);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }
	
	@Override
	public List<Goods> getData(String json) {
		List<Goods> goodss = JSON.parseArray(json, Goods.class);
		return goodss;
	}

	@Override
	public List<Goods> findbyTimeAndName(Date goodsTime, String shopName) {
		log.debug("finding all Goods instances");
		try {
			String queryString = "from Goods as g where g.goodsTime=? and shopName=?";
			return getHibernateTemplate().find(queryString,new Object[]{goodsTime, shopName});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Goods> getByOpDate(String startTime, String endTime) throws Exception {
		log.debug("finding Goods instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
			String queryString="from Goods as model where model.goodsTime " +
					"between ? and ? order by model.goodsTime asc";
			return getHibernateTemplate().find(queryString, new Object[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}
}