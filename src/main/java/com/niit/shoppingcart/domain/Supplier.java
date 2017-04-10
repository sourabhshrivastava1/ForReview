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
@Table(name="Supplier")  //if the class name and table name is different
@Component               //if want to cerate instance of Class Supplier  - supplier
public class Supplier {
	
	//add simple properties - same as Supplier table
	//generate getter/setter methods
	
	@Id
	private String id;
	
	@Column(name="name")  //if the field name and property name is different
	private String name;
	
	private String address;
/*	
	@OneToMany(mappedBy="supplier",fetch = FetchType.EAGER)
	private Set<Product> products;
	
*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
