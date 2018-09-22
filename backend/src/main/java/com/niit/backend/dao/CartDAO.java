package com.niit.backend.dao;

import com.niit.backend.dto.Cart;

public interface CartDAO {
	boolean addCart(Cart cart);
	Cart getCartByCustomer(String customerId);
	boolean deleteCart(int cartId);
}
