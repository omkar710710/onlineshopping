package net.km.shoppingbackend1.dao;

import java.util.List;

import net.km.shoppingbackend1.dto.Cart;
import net.km.shoppingbackend1.dto.CartLine;
import net.km.shoppingbackend1.dto.OrderDetail;


public interface CartLineDAO {

	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	//other business methods
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	
	boolean updateCart(Cart cart);
	boolean addOrderDetail(OrderDetail orderDetail);
}
