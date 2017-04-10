package com.niit.shoppingcart.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.MyCart;

@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO {
	private static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl() {

	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<MyCart> list(String userID) {
		log.debug("Starting of the method list");
		String hql = "from MyCart where userID=" + "'" + userID + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method list");
		return query.list();

	}

	@Transactional
	public boolean save(MyCart cart) {
		log.debug("Starting of the method save");

		cart.setUser_id(getMaxId());
		sessionFactory.getCurrentSession().save(cart);
		log.debug("Ending of the method save");
		return false;
	}

	private String getMaxId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Long getTotalAmount(String userID) {
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price) from MyCart where userID=" + "'" + userID + "' " + "  and status = " + "'N'";
		log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (Long) query.uniqueResult();

	}
/*
	private String getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from MyCart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			maxID = (Long) query.uniqueResult();
		} catch (HibernateException e) {
			log.debug("It seems this is first record. setting initial id is 100 :");
			maxID = 100L;
			e.printStackTrace();
		}
		log.debug("Max id :" + maxID);
		return maxID + 1;

	}
*/
	public List<MyCart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public MyCart getSupplier(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(MyCart mycart) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(MyCart mycart) {
		// TODO Auto-generated method stub
		return false;
	}
}
