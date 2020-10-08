package net.km.shoppingbackend1.dao;

import java.util.List;

import net.km.shoppingbackend1.dto.Category;

public interface CategoryDAO {
	
	
	
	boolean add(Category category);
	
	List<Category> list();
	
	Category get(int id);
	
	boolean update(Category category);
	
	boolean delete(Category category);
	

}
