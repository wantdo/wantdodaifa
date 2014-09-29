package com.wantdo.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alibaba.fastjson.JSON;
import com.wantdo.dao.IOrderJdDAO;
import com.wantdo.pojo.OrderJd;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderJd entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.pojo.OrderJd
 * @author MyEclipse Persistence Tools
 */
public class OrderJdDAO extends HibernateDaoSupport implements IOrderJdDAO{
	private static final Logger log = LoggerFactory.getLogger(OrderJdDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String ADDRESS = "address";
	public static final String PHONE = "phone";
	public static final String ORDER_ID = "orderId";
	public static final String ORDER_NO = "orderNo";
	public static final String GOODINFO = "goodinfo";
	public static final String PRIME_COST = "primeCost";
	public static final String DISCOUNT_COST = "discountCost";
	public static final String ORDER_NUM = "orderNum";
	public static final String ORDER_PRICE = "orderPrice";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(OrderJd transientInstance) {
		log.debug("saving OrderJd instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderJd persistentInstance) {
		log.debug("deleting OrderJd instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderJd findById(java.lang.Integer id) {
		log.debug("getting OrderJd instance with id: " + id);
		try {
			OrderJd instance = (OrderJd) getHibernateTemplate().get(
					"com.wantdo.pojo.OrderJd", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderJd instance) {
		log.debug("finding OrderJd instance by example");
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
		log.debug("finding OrderJd instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderJd as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByOrderId(Object orderId) {
		return findByProperty(ORDER_ID, orderId);
	}

	public List findByOrderNo(Object orderNo) {
		return findByProperty(ORDER_NO, orderNo);
	}

	public List findByGoodinfo(Object goodinfo) {
		return findByProperty(GOODINFO, goodinfo);
	}

	public List findByPrimeCost(Object primeCost) {
		return findByProperty(PRIME_COST, primeCost);
	}

	public List findByDiscountCost(Object discountCost) {
		return findByProperty(DISCOUNT_COST, discountCost);
	}

	public List findByOrderNum(Object orderNum) {
		return findByProperty(ORDER_NUM, orderNum);
	}

	public List findByOrderPrice(Object orderPrice) {
		return findByProperty(ORDER_PRICE, orderPrice);
	}

	public List findByVersion(Object version) {
		return findByProperty(VERSION, version);
	}

	public List findAll() {
		log.debug("finding all OrderJd instances");
		try {
			String queryString = "from OrderJd";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderJd merge(OrderJd detachedInstance) {
		log.debug("merging OrderJd instance");
		try {
			OrderJd result = (OrderJd) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderJd instance) {
		log.debug("attaching dirty OrderJd instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderJd instance) {
		log.debug("attaching clean OrderJd instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderJdDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderJdDAO) ctx.getBean("OrderJdDAO");
	}
	
	@Override
	public List<OrderJd> getData(String json) {
		List<OrderJd> orderJds = JSON.parseArray(json, OrderJd.class);
		return orderJds;
	}
}