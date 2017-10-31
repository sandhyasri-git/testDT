package com.niit.mobilesbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTest {
	static AnnotationConfigApplicationContext context;
	
	public static void main(String[] args) {
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		System.out.println("product Test");
		// TODO Auto-generated method stub

	}

}
