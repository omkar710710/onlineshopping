package net.km.shoppingbackend1.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.km.shoppingbackend1.dao.CategoryDAO;
import net.km.shoppingbackend1.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	
@Autowired
private SessionFactory sessionFactory;



	
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
		
		
		
	}

	
	//Getting Single Category based on id
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id)) ;
	}

	public boolean add(Category category) {
		try {
			//add the category to database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

	//updating a single category
public boolean update(Category category) {
	try {
		//add the category to database table
		sessionFactory.getCurrentSession().update(category);
		return true;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
	
}

public boolean delete(Category category) {
	category.setActive(false); 
	try {
		//add the category to database table
		sessionFactory.getCurrentSession().update(category);
		return true;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		return false;
	}
}

}
