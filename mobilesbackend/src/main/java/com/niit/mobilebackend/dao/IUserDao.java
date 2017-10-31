package com.niit.mobilebackend.dao;

import java.util.List;

import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.User;

public interface IUserDao {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public User get(String email);
	public List<User>getAllUsers();
	//public User getbyid(int i);
	public User getbyid(int id);

}
