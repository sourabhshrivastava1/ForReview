package com.niit.shoppingcart.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="My_cart")  //if the class name and table name is different
@Component               //if want to cerate instance of Class Supplier  - supplier
public class MyCart {
	
	//add simple properties - same as Supplier table
	//generate getter/setter methods
	
	@Id
	
	//if the field name and property name is different
	private String user_id;
	
	private String product_name;
	@Column
	private String price;
	
	private String quantity;
	
	private String date_added;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public void setStatus(char c) {
		// TODO Auto-generated method stub
		
	}
	
	
}
/*	
	@OneToMany(mappedBy="supplier",fetch = FetchType.EAGER)
	private Set<Product> products;
	
*/
	