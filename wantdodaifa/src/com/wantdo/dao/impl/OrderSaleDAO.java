package com.wantdo.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.alibaba.fastjson.JSON;
import com.wantdo.dao.IOrderSaleDAO;
import com.wantdo.pojo.OrderSale;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderSale entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wantdo.pojo.OrderSale
 * @author MyEclipse Persistence Tools
 */
public class OrderSaleDAO extends HibernateDaoSupport implements IOrderSaleDAO{
	private static final Logger log = LoggerFactory
			.getLogger(OrderSaleDAO.class);
	// property constants
	public static final String SALES = "sales";
	public static final String SHOP_NAME = "shopName";
	public static final String CLIENT_NAME = "clientName";
	public static final String GOODS_NUM = "goodsNum";

	protected void initDao() {
		// do nothing
	}

	public void save(OrderSale transientInstance) {
		log.debug("saving OrderSale instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderSale persistentInstance) {
		log.debug("deleting OrderSale instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderSale findById(java.lang.Integer id) {
		log.debug("getting OrderSale instance with id: " + id);
		try {
			OrderSale instance = (OrderSale) getHibernateTemplate().get(
					"com.wantdo.pojo.OrderSale", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderSale instance) {
		log.debug("finding OrderSale instance by example");
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
		log.debug("finding OrderSale instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderSale as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySales(Object sales) {
		return findByProperty(SALES, sales);
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findByClientName(Object clientName) {
		return findByProperty(CLIENT_NAME, clientName);
	}

	public List findByGoodsNum(Object goodsNum) {
		return findByProperty(GOODS_NUM, goodsNum);
	}

	public List findAll() {
		log.debug("finding all OrderSale instances");
		try {
			String queryString = "from OrderSale";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderSale merge(OrderSale detachedInstance) {
		log.debug("merging OrderSale instance");
		try {
			OrderSale result = (OrderSale) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderSale instance) {
		log.debug("attaching dirty OrderSale instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderSale instance) {
		log.debug("attaching clean OrderSale instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderSaleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OrderSaleDAO) ctx.getBean("OrderSaleDAO");
	}
	
	
	public List<OrderSale> getData(String json) {
		List<OrderSale> orderSales = JSON.parseArray(json, OrderSale.class);
		return orderSales;
	}

	@Override
	public List<OrderSale> findbyTimeAndName(Date saleTime, String shopName) {
		log.debug("finding all OrderSale instances");
		try {
			String queryString = "from OrderSale as os where os.saleTime=? and os.shopName=?";
			return getHibernateTemplate().find(queryString,new Object[]{saleTime,shopName});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public List<OrderSale> findbyTimeAndNameAndClient(Date saleTime,
			String shopName) {
		log.debug("finding all OrderSale instances");
		try {
			String queryString = "select DISTINCT os.clientName from OrderSale as os where os.saleTime=? and os.shopName=?";
			return getHibernateTemplate().find(queryString,new Object[]{saleTime,shopName});
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}