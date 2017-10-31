package com.niit.mobilebackend.dao;

import java.util.List;

import com.niit.mobilebackend.model.Product;

public interface IProductDao {
	public void saveProduct(Product product);
	public Product get(int id);
	public List<Product> list();
	public void delete(Product product);

}
