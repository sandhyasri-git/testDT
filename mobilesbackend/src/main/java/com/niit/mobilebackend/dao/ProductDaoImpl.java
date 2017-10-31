package com.niit.mobilebackend.dao;

 

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilebackend.model.Category;
import com.niit.mobilebackend.model.Product;
import com.niit.mobilebackend.model.Supplier;

@Repository("productDao")
public class ProductDaoImpl implements IProductDao {
@Autowired
SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory2) {
	// TODO Auto-generated constructor stub
}
	public void saveProduct(Product product) {
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.save(product);
		t.commit();
		
		// TODO Auto-generated method stub

	}
	@Transactional
	public List<Product> list() {
		/*try
		{
			return sessionFactory.openSession().createQuery("from Product",Product.class).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}*/
		Session s=sessionFactory.openSession();
		Transaction tx=s.beginTransaction();
		Query query=s.createQuery("From Product");
		List<Product>cat =query.list();
		if(cat!=null)
		{
			return cat;
		}
		else
		{
			System.out.println("list empty");
			return null;
		}
	}
	/*public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/
	public void delete(Product product) {
		
			Session s=sessionFactory.getCurrentSession();
			System.out.println("i am in dao");
			Transaction t=s.beginTransaction();
			s.delete(product);
			t.commit();
		}
			
			
		

		public Product get(int id) {
			String hql="from Product where prodid="+id;
			Session s=sessionFactory.openSession();
			System.out.println("i am in get");
			Transaction t=s.beginTransaction();
			Query query=s.createQuery(hql);
			List<Product>prod=query.list();
			if(prod==null)
			{
				return null;
			}
			else
			{
				System.out.println("List is empty");
				return prod.get(0);
			}
			
		
	}

}
