package com.niit.mobilebackend.dao;

import java.util.List;

import com.niit.mobilebackend.model.Category;

public interface ICategoryDao {
	public void saveCategory(Category category);
	public List<Category>getCategories();
	public void delete(Category category);
	public Category get(int id);

}
