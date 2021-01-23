package net.km.shoppingbackend1.dao;

import java.util.List;

import net.km.shoppingbackend1.dto.Address;
import net.km.shoppingbackend1.dto.Cart;
import net.km.shoppingbackend1.dto.User;

public interface UserDAO {
	//Add User
	boolean addUser(User user);
	User getByEmail(String email);
	//Add Cart
	//boolean addCart(Cart cart);
	boolean updateCart(Cart cart);
	//Add Address
	boolean addAddress(Address address);
	
	Address getBillingAddress(int userId);
	
	List<Address> listShippingAddress(int userId);
	Address getAddress(int addressId);
	boolean updateAddress(Address address);
}
