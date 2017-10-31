 package com.niit.mobilebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.mobilebackend.dao.CartDaoImpl;
import com.niit.mobilebackend.dao.CartItemDaoImpl;
import com.niit.mobilebackend.dao.CategoryDaoImpl;
import com.niit.mobilebackend.dao.ICartDao;
import com.niit.mobilebackend.dao.ICartItemDao;
import com.niit.mobilebackend.dao.ICategoryDao;
import com.niit.mobilebackend.dao.IProductDao;
import com.niit.mobilebackend.dao.ISupplierDao;
import com.niit.mobilebackend.dao.IUserDao;
import com.niit.mobilebackend.dao.ProductDaoImpl;
import com.niit.mobilebackend.dao.SupplierDaoImpl;
import com.niit.mobilebackend.dao.UserDaoImpl;
import com.niit.mobilebackend.model.Cart;
import com.niit.mobilebackend.model.CartItem;
import com.niit.mobilebackend.model.Category;
import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.Supplier;
import com.niit.mobilebackend.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationConfig {
	@Bean(name= "dataSource")
	public DataSource getdatasource() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Ameer");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("data source");
		return dataSource;
	}
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.current_session_context_class", "thread");
		System.out.println("hibernate");
		return properties;
		
		
	}
	
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		sessionBuilder.addAnnotatedClasses(CartItem.class);


		System.out.println("session factory");
		return sessionBuilder.buildSessionFactory();
		
		
	}
	@Autowired
	@Bean(name="productDao")
	public IProductDao getProductDao(SessionFactory sessionFactory)
	{
		return new ProductDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="product")
	public Product getProduct() {
		return new Product();
	}
	@Autowired
	@Bean(name="categoryDao")
	public ICategoryDao getCategoryDao(SessionFactory sessionFactory)
	{
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="category")
	public Category getCategory() {
		return new Category();
	}
	@Autowired
	@Bean(name="supplierDao")
	public ISupplierDao getSupplierDao(SessionFactory sessionFactory)
	{
		return new SupplierDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="supplier")
	public Supplier getSupplier() {
		return new Supplier();
	}
	@Autowired
	@Bean(name="userDao")
	public IUserDao getUserDao(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="user")
	public User getUser()
	{
		return new User();
	}
	@Autowired
	@Bean(name="cartDao")
	public ICartDao getCartDao(SessionFactory sessionFactory)
	{
		return new CartDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="cart")
	public Cart getCart()
	{
		return new Cart();
		
	}
	
	@Autowired
	@Bean(name="cartitemDao")
	public ICartItemDao getCartItemDao(SessionFactory sessionFactory)
	{
		return new CartItemDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="cartitem")
	public CartItem getCartItem()
	{
		return new CartItem();
		
	}
	
	
	
	
	@Autowired
	@Bean(name ="transactionmanager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager =new HibernateTransactionManager(sessionFactory);
		return transactionManager;
		
	}
	
	

}
