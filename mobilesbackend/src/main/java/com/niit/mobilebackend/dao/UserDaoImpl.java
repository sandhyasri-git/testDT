package com.niit.mobilebackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
@Autowired
private SessionFactory sessionFactory;
public UserDaoImpl(SessionFactory sessionFactory2) {
	// TODO Auto-generated constructor stub
}
public boolean addUser(User user)
{
	Session s=sessionFactory.openSession();
	Transaction tx=s.beginTransaction();
	s.saveOrUpdate(user);
	tx.commit();
	return true;
	
}
@Transactional
public User get(String email) {
	try {
		return sessionFactory.openSession().createQuery("from User where emailid=:email",User.class).setParameter("email", email).getSingleResult();
	}
	catch(Exception e)
	{
		System.out.println(e);
		return null;
	}
	
}
@SuppressWarnings({"deprecation","rawtypes","unchecked"})
public List<User> getAllUsers()
{
	Session s=sessionFactory.openSession();
	Transaction tx=s.beginTransaction();
	Query query=s.createQuery("From User");
	List<User>us=query.list();
	if(us!=null)
	{
		return us;
	}
	else
	{
		System.out.println("list empty");
		return null;
	}
}
public boolean deleteUser(User user) {
	// TODO Auto-generated method stub
	return false;
}
public User getbyid(int id) {
	String hql="from User where userid="+id;
	Session s=sessionFactory.openSession();
	Transaction tx=s.beginTransaction();
	Query query=s.createQuery(hql);
	List<User>us=query.list();
	if(us==null)
	{
		return null;
	}
	else
	{
		System.out.println("list empty");
		return us.get(0);
	}
}
}


