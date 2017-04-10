package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.MyCart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;






@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}

	@Autowired
	@Bean(name ="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(MyCart.class);
	
		return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver(){
		CommonsMultipartResolver multipartResolver= new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(1048576);
		return 	multipartResolver;
	}
  /* @Bean(name="springSecurityFilterChain")
   public DelegatingFilterProxy getFilterChainProxy()
   {
	   DelegatingFilterProxy obj= new DelegatingFilterProxy();
	   return obj;
   }*/
}

