package com.wantdo.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alibaba.fastjson.JSON;
import com.wantdo.dao.ITShopReflectDAO;
import com.wantdo.pojo.HotGoodsRank;
import com.wantdo.pojo.TShopReflect;

/**
 * A data access object (DAO) providing persistence and search support for
 * TShopReflect entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.pojo.TShopReflect
 * @author MyEclipse Persistence Tools
 */
public class TShopReflectDAO extends HibernateDaoSupport implements ITShopReflectDAO{
	private static final Logger log = LoggerFactory
			.getLogger(TShopReflectDAO.class);
	// property constants
	public static final String SHOP_ID = "shopId";
	public static final String SHOP_NO = "shopNo";
	public static final String SHOP_NAME_CAPTURE = "shopNameCapture";
	public static final String SHOP_NAME = "shopName";
	public static final String TEXT1 = "text1";
	public static final String TEXT2 = "text2";
	public static final String TEXT3 = "text3";

	protected void initDao() {
		// do nothing
	}

	public void save(TShopReflect transientInstance) {
		log.debug("saving TShopReflect instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TShopReflect persistentInstance) {
		log.debug("deleting TShopReflect instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TShopReflect findById(java.lang.Integer id) {
		log.debug("getting TShopReflect instance with id: " + id);
		try {
			TShopReflect instance = (TShopReflect) getHibernateTemplate().get(
					"com.wantdo.pojo.TShopReflect", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShopReflect instance) {
		log.debug("finding TShopReflect instance by example");
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
		log.debug("finding TShopReflect instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TShopReflect as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopId(Object shopId) {
		return findByProperty(SHOP_ID, shopId);
	}

	public List findByShopNo(Object shopNo) {
		return findByProperty(SHOP_NO, shopNo);
	}

	public List findByShopNameCapture(Object shopNameCapture) {
		return findByProperty(SHOP_NAME_CAPTURE, shopNameCapture);
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findByText1(Object text1) {
		return findByProperty(TEXT1, text1);
	}

	public List findByText2(Object text2) {
		return findByProperty(TEXT2, text2);
	}

	public List findByText3(Object text3) {
		return findByProperty(TEXT3, text3);
	}

	public List findAll() {
		log.debug("finding all TShopReflect instances");
		try {
			String queryString = "from TShopReflect";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShopReflect merge(TShopReflect detachedInstance) {
		log.debug("merging TShopReflect instance");
		try {
			TShopReflect result = (TShopReflect) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShopReflect instance) {
		log.debug("attaching dirty TShopReflect instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TShopReflect instance) {
		log.debug("attaching clean TShopReflect instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TShopReflectDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TShopReflectDAO) ctx.getBean("TShopReflectDAO");
	}

	@Override
	public List<TShopReflect> getData(String json) {
		List<TShopReflect> tShopReflect = JSON.parseArray(json, TShopReflect.class);
		return tShopReflect;
	}

	@Override
	public void update(TShopReflect tShopReflect) {
		log.debug("updating TShopReflect instance");
        try {
            getHibernateTemplate().update(tShopReflect);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
	}
}