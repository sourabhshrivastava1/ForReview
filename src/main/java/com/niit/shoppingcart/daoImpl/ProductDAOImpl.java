package com.niit.shoppingcart.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	
	}

	public boolean save(Product product) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(product);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
		
	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	
	}

	public boolean delete(String id) {
		
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public Product getProductByID(String id) {
		// TODO Auto-generated method stub
		 return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where id = '"+id + "'").uniqueResult();
	}

	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		  return  (Product) sessionFactory.getCurrentSession().createQuery("from Product where name = '"+name + "'").list().get(0);
			
	}

	public boolean saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public Product get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
