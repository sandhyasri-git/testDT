package com.niit.mobilesbackend;

/*import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.mobilebackend.dao.IProductDao;
import com.niit.mobilebackend.model.Product;

public class ProductTestCase {
	static AnnotationConfigApplicationContext context;
	static IProductDao productDao;
	static Product product;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		productDao=(IProductDao)context.getBean("productDao");
	}
    
	@Test
	public void test() {
		product=new Product();
		product.setProdname("sony");
		product.setQuantity(2);
		product.setPrice(25000);
		productDao.saveProduct(product);
		assertEquals("inserted",true);
	}

}*/
