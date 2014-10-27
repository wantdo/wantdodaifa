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
import com.wantdo.dao.ISaleDAO;
import com.wantdo.pojo.Goods;
import com.wantdo.pojo.Sale;

/**
 * A data access object (DAO) providing persistence and search support for Sale
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wantdo.pojo.Sale
 * @author MyEclipse Persistence Tools
 */
public class SaleDAO extends HibernateDaoSupport implements ISaleDAO{
	private static final Logger log = LoggerFactory.getLogger(SaleDAO.class);
	// property constants
	public static final String SALES = "sales";
	public static final String ORDER_QUANTITY = "orderQuantity";
	public static final String ORDER_GOODS_NUM = "orderGoodsNum";
	public static final String ORDER_CLIENT_NUM = "orderClientNum";
	public static final String CLIENT_PRICE = "clientPrice";
	public static final String SHOP_NAME = "shopName";
	public static final String PLATFORM = "platform";
	public static final String VERSION = "version";

	protected void initDao() {
		// do nothing
	}

	public void save(Sale transientInstance) {
		log.debug("saving Sale instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sale persistentInstance) {
		log.debug("deleting Sale instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sale findById(java.lang.Integer id) {
		log.debug("getting Sale instance with id: " + id);
		try {
			Sale instance = (Sale) getHibernateTemplate().get(
					"com.wantdo.pojo.Sale", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sale instance) {
		log.debug("finding Sale instance by example");
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
		log.debug("finding Sale instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sale as model where model."
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

	public List findByOrderQuantity(Object orderQuantity) {
		return findByProperty(ORDER_QUANTITY, orderQuantity);
	}

	public List findByOrderGoodsNum(Object orderGoodsNum) {
		return findByProperty(ORDER_GOODS_NUM, orderGoodsNum);
	}

	public List findByOrderClientNum(Object orderClientNum) {
		return findByProperty(ORDER_CLIENT_NUM, orderClientNum);
	}

	public List findByClientPrice(Object clientPrice) {
		return findByProperty(CLIENT_PRICE, clientPrice);
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
		log.debug("finding all Sale instances");
		try {
			String queryString = "from Sale";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sale merge(Sale detachedInstance) {
		log.debug("merging Sale instance");
		try {
			Sale result = (Sale) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sale instance) {
		log.debug("attaching dirty Sale instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sale instance) {
		log.debug("attaching clean Sale instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SaleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SaleDAO) ctx.getBean("SaleDAO");
	}
	@Override
	public List<Sale> getData(String json) {
		List<Sale> sales = JSON.parseArray(json, Sale.class);
		return sales;
	}

	@Override
	public List<Sale> findbyTimeAndName(Date saleTime, String shopName) {
		log.debug("finding all Sale instances");
		try {
			String queryString = "from Sale as s where s.saleTime=? and shopName=?";
			return getHibernateTemplate().find(queryString,new Object[]{saleTime,shopName});
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List getByOpDate(String startTime, String endTime) throws Exception {
		log.debug("finding Sale instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
			String queryString="SELECT shopName,platform,SUM (CAST(sales AS float)) AS sumSales,COUNT (*) AS orderNum,SUM (CAST(goodsNum AS float)) AS sumGoodsnum,SUM (CAST(sales AS float)) / COUNT (*) AS clientprice FROM OrderSale WHERE saleTime BETWEEN ? AND ? GROUP BY shopName,platform  ORDER BY SUM (CAST(sales AS float)) desc"; 
			return getHibernateTemplate().find(queryString, new Object[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}

	@Override
	public List getByOpDayDate(String startTime, String endTime)
			throws Exception {
		log.debug("finding Sale instance with startTime: " + startTime+" and endTime:"+endTime);
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
//			String queryString="select model.saleTime,model.shopName,model.sales,model.clientPrice,f.shopDealRate from Sale as model,Flow f where model.shopName = f.shopName and model.saleTime = f.flowTime and model.saleTime " +
//					"between ? and ? order by model.saleTime asc";
			String queryString="from Sale as model,Flow f where model.shopName = f.shopName and model.saleTime = f.flowTime and model.saleTime " +
					"between ? and ? order by model.saleTime asc";
			return getHibernateTemplate().find(queryString, new Object[]{sdf.parse(startTime),sdf.parse(endTime)});
		} catch (RuntimeException re) {
			// TODO: handle exception
			log.error("find by startTime and endTime failed", re);
			throw re;
		}
	}

	@Override
	public void update(Sale sale) {
		log.debug("updating Sale instance");
        try {
            getHibernateTemplate().update(sale);
            log.debug("update successful");
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
	}
}