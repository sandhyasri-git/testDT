package com.niit.mobilebackend.dao;

import java.util.List;

import com.niit.mobilebackend.model.CartItem;

public interface ICartItemDao {
	public boolean addCartItem(CartItem cartItem);
	public List<CartItem> getAll();
	public boolean deleteCartItem(CartItem cartItem);
	public CartItem getCartItem(int id);
	public boolean deleteAll(int cart_id);
	public CartItem getExistingCartItemCount(int prodid, int cart_id);
	public boolean updateCartItem(CartItem cartItem);



}

