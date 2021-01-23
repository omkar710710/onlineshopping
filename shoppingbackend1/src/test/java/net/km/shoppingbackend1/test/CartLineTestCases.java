package net.km.shoppingbackend1.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.km.shoppingbackend1.dao.CartLineDAO;
import net.km.shoppingbackend1.dao.ProductDAO;
import net.km.shoppingbackend1.dao.UserDAO;
import net.km.shoppingbackend1.dto.Cart;
import net.km.shoppingbackend1.dto.CartLine;
import net.km.shoppingbackend1.dto.Product;
import net.km.shoppingbackend1.dto.User;

public class CartLineTestCases {
	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO=null;
	private static ProductDAO productDAO=null;
	private static UserDAO userDAO=null;
	
	
	
	private Product product=null;
	private User user=null;
	private Cart cart=null;
	private CartLine cartLine=null;
	
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.km.shoppingbackend1");		
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		
	}
	
	@Test
	public void testAdNewCartLine()
	{
		User user = userDAO.getByEmail("omkarghoman7@gmail.com");
		
		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(1);
		
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add cartline",true,cartLineDAO.add(cartLine));
		//update the cart
		
		cart.setGrandTotal(cart.getGrandTotal()+ cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("Failed to update the cart",true,cartLineDAO.updateCart(cart));
	}
	
}
