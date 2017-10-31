package com.niit.mobilebackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilebackend.model.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements ICartDao {
	@Autowired
	IProductDao productDAO;
	
	@Autowired
	IUserDao userDAO;

	@Autowired
	private SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Cart cart) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(cart);
			t.commit();
			//sessionFactory.getCurrentSession().save(cart);
			System.out.println("saving into cart...impl");
			
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}
	@Transactional
	public boolean update(Cart cart) {
		try {
			Session s = sessionFactory.openSession();
			System.out.println("in update of cart");
			Transaction tx = s.beginTransaction();
			s.update(cart);
			tx.commit();
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
			
		}

	}
	@Transactional
	public boolean delete(Cart cart) {
		try {
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			s.delete(cart);
			tx.commit();
			s.close();
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}

	}
	@Transactional
	public Cart getbyid(int id) {
		try {
			String hql = "from Cart where cartid=" + id;
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery(hql);
			List<Cart> list = query.list();
			tx.commit();
			if (list == null){
				return null;}
			else {
				System.out.println("getting by id product.......in impl");

				return list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	@Transactional
	public Cart get(int cartid, int id) {
		System.out.println("Inside get method of Cart Dao");
		System.out.println("cartid:" + id);
		System.out.println("user id "+cartid);
		String hql = "from Cart where user_userid="+cartid+"and cartid="+ id;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery(hql);
		List<Cart> list = query.getResultList();
		
		tx.commit();

		if (list != null) {
			System.out.println("Record available");
			return  list.get(0);
			
		} else {
			return null;
		}

	}
	@Transactional
	public List<Cart> listcartproducts(int id) {
		try {
			String hql = "from Cart where user_userid=" +id;
			System.out.println("In List Products "+id);
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			System.out.println("listing cart product.......in impl");
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	@Transactional
	public int totalproducts(int id) {
		try {
			String hql = "from Cart where userid=" +id;
			Session s = sessionFactory.openSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			int k = 0;
			for (Cart temp : all) {
				k = k + 1;
			}
			System.out.println("total products in ......impl");
			return k;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}

	}
	@Transactional
	public int totalprice(int id) {
/*try{
			
			String hql = "from Cart where userID=" + id;
			Query query = sessionFactory.openSession().createQuery(hql);
			List<Cart> all = query.list();
	
			float k=0;
			for (Cart temp : all) {
				k = k + temp.getPrice();
			}		
			return (int) k;	
		} catch (HibernateException e) {
			e.printStackTrace();
			
		}*/
		return 0;
	}
	@Transactional
	public List<Cart> list() {
		try {
			String hql = "from Cart";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			tx.commit();
			return all;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	@Transactional
	public boolean resetCart(int id) {
		try{
			Cart cart=  getCart(id);
			cart.setGrandtotal(0);
			cart.setQty(0);
			update(cart);
			return true;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return false;
			}
	}
	
	@Transactional
	public Cart getCart(int id) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			String str="from Cart where cartid="+id;
			Query q=s.createQuery(str);
			List<Cart>list=q.getResultList();
			t.commit();
			if(list!=null)
			{
				return list.get(0);
			}
			else
			{
				return null;
			}
			//return	sessionFactory.openSession().createQuery("from Cart where cartid=:id ",Cart.class).setParameter("id", id).getSingleResult();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return null;
			}
	}
	@Transactional
	public Cart getCartWithUserId(Integer id) {
		try {
			Session s=sessionFactory.getCurrentSession();
			Transaction t=s.beginTransaction();
			String str="from Cart where user_userid="+id;
			Query q=s.createQuery(str);
			List<Cart>list=q.getResultList();
			t.commit();
			if(list!=null)
			{
				return (Cart) list;
			}
			else
			{
				return null;
			}
			
			//return (Cart) sessionFactory.openSession().createQuery("from Cart where user_userid=:id",Cart.class)
										//.setParameter("id", id).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}


}
