package net.km.shoppingbackend1.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.km.shoppingbackend1.dao.UserDAO;
import net.km.shoppingbackend1.dto.Address;
import net.km.shoppingbackend1.dto.Cart;
import net.km.shoppingbackend1.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public boolean addUser(User user) {
		try {
			//add user to database table
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	

	
	
	
	public boolean updateCart(Cart cart) {
		
		try {
			//add user to database table
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addAddress(Address address) {
		 try {
		sessionFactory.getCurrentSession().persist(address);
		return true;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	}

	public User getByEmail(String email) {
		String selectQuery="FROM User WHERE email=:email";
		try {
		return	sessionFactory.getCurrentSession().createQuery(selectQuery,User.class)
			.setParameter("email",email).getSingleResult();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}






	public Address getBillingAddress(int userId) {
		String selectQuery="FROM Address WHERE userId = :userId AND billing=:billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery,Address.class)
					.setParameter("userId", userId).setParameter("billing", true).getSingleResult();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}






	public List<Address> listShippingAddress(int userId) {

		String selectQuery="FROM Address WHERE userId = :userId AND shipping=:shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery,Address.class)
					.setParameter("userId", userId).setParameter("shipping", true)
					.getResultList();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}






	public Address getAddress(int addressId) {
		try {			
			return sessionFactory.getCurrentSession().get(Address.class, addressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}






	public boolean updateAddress(Address address) {
		try {			
			sessionFactory.getCurrentSession().update(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

}
