package com.wantdo.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.ICusShopsDAO;
import com.wantdo.pojo.CusShops;

/**
 * A data access object (DAO) providing persistence and search support for
 * CusShops entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.domain.CusShops
 * @author MyEclipse Persistence Tools
 */
public class CusShopsDAO extends HibernateDaoSupport implements ICusShopsDAO{
	private static final Logger log = LoggerFactory
			.getLogger(CusShopsDAO.class);
	// property constants
	public static final String SHOPNAME = "shopname";
	public static final String SHOPMANAGER = "shopmanager";
	public static final String SHOPEMAIL = "shopemail";
	public static final String SHOPNO = "shopno";

	protected void initDao() {
		// do nothing
	}

	public void save(CusShops transientInstance) {
		log.debug("saving CusShops instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CusShops persistentInstance) {
		log.debug("deleting CusShops instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(CusShops updateInstance) {
        log.debug("updating CusShops instance");
        try {
            getHibernateTemplate().update(updateInstance);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

	public CusShops findById(java.lang.Integer id) {
		log.debug("getting CusShops instance with id: " + id);
		try {
			CusShops instance = (CusShops) getHibernateTemplate().get(
					"com.wantdo.domain.CusShops", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CusShops instance) {
		log.debug("finding CusShops instance by example");
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
		log.debug("finding CusShops instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CusShops as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopname(Object shopname) {
		return findByProperty(SHOPNAME, shopname);
	}

	public List findByShopmanager(Object shopmanager) {
		return findByProperty(SHOPMANAGER, shopmanager);
	}

	public List findByShopemail(Object shopemail) {
		return findByProperty(SHOPEMAIL, shopemail);
	}

	public List findByShopno(Object shopno) {
		return findByProperty(SHOPNO, shopno);
	}

	public List findAll() {
		log.debug("finding all CusShops instances");
		try {
			String queryString = "from CusShops";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CusShops merge(CusShops detachedInstance) {
		log.debug("merging CusShops instance");
		try {
			CusShops result = (CusShops) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CusShops instance) {
		log.debug("attaching dirty CusShops instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CusShops instance) {
		log.debug("attaching clean CusShops instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CusShopsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CusShopsDAO) ctx.getBean("CusShopsDAO");
	}
}