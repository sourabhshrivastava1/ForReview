package com.niit.shoppingcart.dao;

import java.util.List;
import com.niit.shoppingcart.domain.User;

public interface UserDAO {

	// declare the methods related to CRUD operations
	// access_specifier return_type method_name(parameter_list) throws
	// exception_list

	// get all categories

	public List<User> list();

	// create user

	public User getUser(String id);
	// update user

	public boolean save(User user);
	// delete user by id

	public boolean update(User user);
	// delete user by user

	public boolean validate(String id, String password);


	// get user by name
	public User getUserByName(String name);

	public User isValidUser(String userid, String password);

	
	public Object get(String id);

	public boolean delete(User user);

}
