package com.niit.shoppingcart.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;


public class SupplierTestCase {
	

		@Autowired
		private static Supplier supplier;
		
		@Autowired
		private static SupplierDAO supplierDAO;
		
		@BeforeClass
		public static void init()
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.niit.shoppingcart");
			context.refresh();
			
			supplier = (Supplier) context.getBean("supplier");
			
			supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
			
		}
		@Test
		public void createSupplierTestCase() {
			 
			   supplier.setId("1");
			   supplier.setName("Women");
			   supplier.setAddress("Bittan market");
			
			boolean flag = supplierDAO.save(supplier);

			// compare what you are excepting VS what you are getting from save
			// method

			Assert.assertEquals("createSupplierTestCase", true, flag);
		}
		
		 @Test
		   public void updateSupplierTestCase()
		   {
			   
			   supplier.setId("1");
			   supplier.setName("Women");
			   supplier.setAddress("Bittan market");
			   
			   boolean flag = supplierDAO.update(supplier);
			   
			   Assert.assertEquals( "updateSupplierTestCase" ,true, flag);
			   
		   }
		   
		 
		 
		 @Test
		   public void deleteSupplier()
		   {
			   supplier.setId("CG02032017");
			   
			   boolean flag = supplierDAO.delete(supplier);
			   
			   Assert.assertEquals( "deleteSupplierTestCase" ,true, flag);
			   
			   
		   }
		   
		 
		 @Test
		   public void getAllSupplierTestCase()
		   
		   {
			   
			  int recordsFromDAO =  supplierDAO.list().size();
			  
			  assertEquals("getAllSupplierTestCase" ,2 , recordsFromDAO);
			   
		   }
		   
	}
