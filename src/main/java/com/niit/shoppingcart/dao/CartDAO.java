package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.MyCart;


public interface CartDAO {

	// declare the methods related to CRUD operations
		// access_specifier return_type method_name(parameter_list) throws
		// exception_list

		// get all categories
	public List<MyCart> list(String userID);
	public MyCart getSupplier(String id);
	public boolean save(MyCart cart);
	public boolean update(MyCart cart);
	public boolean delete(MyCart cart);
	public Object getTotalAmount(String userID);

}
