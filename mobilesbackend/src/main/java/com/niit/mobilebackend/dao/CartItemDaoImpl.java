package com.niit.mobilebackend.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilebackend.model.CartItem;

@Repository("cartItemDAO")
@Transactional
public class CartItemDaoImpl implements ICartItemDao {

	@Autowired
	 SessionFactory sessionFactory;
	public CartItemDaoImpl(SessionFactory sessionFactory2) {
		// TODO Auto-generated constructor stub
	}

	public boolean addCartItem(CartItem cartItem) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			s.saveOrUpdate(cartItem);
			t.commit();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public List<CartItem> getAll() {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			String str="from CartItem";
			Query q=s.createQuery(str);
			List<CartItem>ct=q.list();
			t.commit();
			if(ct!=null)
			{
				System.out.println("Cart Item List is not empty");
				return ct;
			}
			else
			{
				System.out.println("Cart Item list is empty");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			s.delete(cartItem);
			t.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public CartItem getCartItem(int id) {
		try {
			Session s=sessionFactory.getCurrentSession();
			
			Transaction t=s.beginTransaction();
			
			String str="from CartItem where cartitemid="+id;
			Query q=s.createQuery(str);
			List<CartItem>ct=q.list();
			t.commit();
			if(ct!=null)
			{
				System.out.println("Inside getCartItem Method");
				return ct.get(0);
			}
			else
			{
				return null;
			}
		}	
			 catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			}
	}

	public boolean deleteAll(int cart_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public CartItem getExistingCartItemCount(int prodid, int cart_id) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			System.out.println("carId "+cart_id+" "+prodid);
			String str="from CartItem where product_prodid="+prodid+" and cart_cartid="+cart_id;
			Query q=s.createQuery(str);
			List<CartItem>ct=q.list();
			t.commit();
			if(ct!=null)
			{
				System.out.println("Inside getExistingCartItemCount");
				return ct.get(0);
			}
			else
			{
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	public boolean updateCartItem(CartItem cartItem) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			s.update(cartItem);
			t.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	


}
