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
import com.niit.mobilebackend.model.Supplier;

@Repository("supplierDao")
@Transactional

public class SupplierDaoImpl implements ISupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory=sessionFactory;
	}

	public boolean saveorUpdate(Supplier supplier) {
		try
		{
			sessionFactory.openSession().saveOrUpdate(supplier);
			return true;
		}catch(Exception e)
		{
			
		}
		// TODO Auto-generated method stub
		return false;
	}

	
		public void delete(Supplier supplier) {
			Session s=sessionFactory.getCurrentSession();
			System.out.println("i am in dao");
			Transaction t=s.beginTransaction();
			s.delete(supplier);
			t.commit();
		}
			
			
		

		public Supplier get(int id) {
			String hql="from Supplier where supplierid="+id;
			Session s=sessionFactory.openSession();
			System.out.println("i am in get");
			Transaction t=s.beginTransaction();
			Query query=s.createQuery(hql);
			List<Supplier>supplier=query.list();
			if(supplier==null)
			{
				return null;
			}
			else
			{
				System.out.println("List is empty");
				return supplier.get(0);
			}
			
		}	

	public List<Supplier> list() {
		try
		{
			return sessionFactory.openSession().createQuery("from Supplier",Supplier.class).getResultList();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}
	

}
