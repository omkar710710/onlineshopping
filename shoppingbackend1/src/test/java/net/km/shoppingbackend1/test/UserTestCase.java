package net.km.shoppingbackend1.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.km.shoppingbackend1.dao.UserDAO;
import net.km.shoppingbackend1.dto.Address;
import net.km.shoppingbackend1.dto.Cart;
import net.km.shoppingbackend1.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	private Address address;
	private Cart cart ;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.km.shoppingbackend1");
		
		context.refresh();
		userDAO=(UserDAO) context.getBean("userDAO");
	
	
	
	}
	
	
	
/*	@Test
	public void testAdd()
	{
		user=new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("12345");
		//add the user
		assertEquals("Failed to add user",true,userDAO.addUser(user));
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		address.setUserId(user.getId());
		assertEquals("Failed to add address",true,userDAO.addAddress(address));
		if(user.getRole().equals("USER")) {
			//create a cart for user
			cart=new Cart();
			cart.setUser(user);
			assertEquals("Failed to add cart",true,userDAO.addCart(cart));
			
			
			// add shipping address
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setShipping(true);
			address.setUserId(user.getId());
			assertEquals("Failed to add shipping address",true,userDAO.addAddress(address));
			
		}
	}	*/	
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		//link user with address using user id
//		address.setUserId(user.getId());
//		//add the address
//		assertEquals("Failed to add address",true,userDAO.addAddress(address));
//		
//		
//		if(user.getRole().equals("USER")) {
//			//create a cart for user
//			cart=new Cart();
//			cart.setUser(user);
//			assertEquals("Failed to add cart",true,userDAO.addCart(cart));
//			//add shipping address
//			address = new Address();
//			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//			address.setAddressLineTwo("Near Kudrat Store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			address.setUserId(user.getId());
//			assertEquals("Failed to add shipping address",true,userDAO.addAddress(address));
//			
//			
//		}
		
		
	
	
	
	/*@Test
	public void testAdd()
	{
		user=new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("12345");
		
		
		if(user.getRole().equals("USER")) {
			//create a cart for user
			cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
			assertEquals("Failed to add user",true,userDAO.addUser(user));
			// add shipping address
			
			
		}
	}	*/	
	
//	@Test
//	public void testUpdateCart()
//	{
//			
//		user=userDAO.getByEmail("hr@gmail.com");
//		
//		cart=user.getCart();
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		assertEquals("Failed to add cart",true,userDAO.updateCart(cart));
//	}
//	
//	@Test
//	public void testAddAddress()
//	{
//		
//		user=new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("12345");
//		//add the user
//		assertEquals("Failed to add user",true,userDAO.addUser(user));
//		
//		
//		
//		//add the address
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		//attach the user to address
//		address.setUser(user);
//		
//		assertEquals("Failed to add address",true,userDAO.addAddress(address));
//		
//		
//		//add the shipping address
//		address = new Address();
//		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//		address.setAddressLineTwo("Near Kudrat Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		//set shipping to true
//		address.setShipping(true);
//		address.setUser(user);
//		assertEquals("Failed to add shipping address",true,userDAO.addAddress(address));
//		
//	}
	
	
	
//	@Test
//	public void testAddAddress()
//	{
//		user=userDAO.getByEmail("hr@gmail.com");
//		
//		
//		
//		address = new Address();
//	address.setAddressLineOne("Radhika kunj ,vikas nagar");
//		address.setAddressLineTwo("Near Kudrat Store");
//		address.setCity("pune");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		//set shipping to true
//		address.setShipping(true);
//		address.setUser(user);
//		assertEquals("Failed to add shipping address",true,userDAO.addAddress(address));
	
//
//	}
//	
	@Test
	public void testGetAddressList()
	{
		user=userDAO.getByEmail("hr@gmail.com");
		assertEquals("Failed to fetch shipping addresses",2,
				userDAO.listShippingAddress(user).size());
		
		
		assertEquals("Failed to fetch the billing address","Mumbai",
				userDAO.getBillingAddress(user).getCity());
		
	}
	
	
	
	
	
	
		
	}
	

