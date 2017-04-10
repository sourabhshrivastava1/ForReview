package com.niit.shoppingcart.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;


@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	private Session getSession1()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<User> list() {
		// TODO Auto-generated method stub
		return  sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	//UserDAOImpl c = new UserDAOImpl
	
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return (User)getSession1().get(User.class,id); 

		
	}

	public boolean save(User user) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(user);
		return true;
		} catch(Exception e)
		{
			e.printStackTrace(); //it will print the error in the console - similar to SOP
			          //package, class, method line number from which place you are calling
			return false;
		}
		
		
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	public boolean validate(String id,String password)
	{
		// TODO Auto-generated method stub
		String hql="from User where id='"+id+"' and password='"+password+"'";
		if(getSession1().createQuery(hql).uniqueResult()==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private SharedSessionContract getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User isValidUser(String userid, String password) {
		// TODO Auto-generated method stub
		return null;
	}



	public Object get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
	}

	


	

	

		
	

	

