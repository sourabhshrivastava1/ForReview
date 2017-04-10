package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {

	// declare the methods related to CRUD operations
		// access_specifier return_type method_name(parameter_list) throws
		// exception_list

		// get all categories
	public List<Supplier> list();
	public Supplier getSupplier(String id);
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	
}
