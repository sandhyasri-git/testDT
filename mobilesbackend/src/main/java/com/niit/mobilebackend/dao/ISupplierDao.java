package com.niit.mobilebackend.dao;

import java.util.List;

import com.niit.mobilebackend.model.Supplier;

public interface ISupplierDao {
	public boolean saveorUpdate(Supplier supplier);
	public void delete(Supplier supplier);
	public Supplier get(int id);
	public List<Supplier> list();

}
