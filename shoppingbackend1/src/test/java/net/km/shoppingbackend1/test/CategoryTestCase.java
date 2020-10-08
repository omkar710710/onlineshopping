package net.km.shoppingbackend1.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.km.shoppingbackend1.dao.CategoryDAO;
import net.km.shoppingbackend1.dto.Category;



public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.km.shoppingbackend1");
		
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	/*@Test
	public void testAddCategory() {
		
		category =new Category();
		category.setName("Mobile");
		category.setDescription("this is it");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Added successfuly",true,categoryDAO.add(category));
	}*/
	
	
/*	@Test
	public void testGetCategory() {
		
		category=categoryDAO.get(1);
		assertEquals("successfully fetched a single category","Television1",category.getName());
		
		
		
	}*/
	
	
/*
	@Test
	public void testUpdateCategory() {
		
		category=categoryDAO.get(1);
		category.setName("Television");
		assertEquals("successfully updated single category",true,categoryDAO.update(category));
		
		
		
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		category=categoryDAO.get(1);
		
		assertEquals("successfully deleted single category",true,categoryDAO.delete(category));
		
		
		
	}*/
	

/*	@Test
	public void testListCategory() {
		
		
		
		assertEquals("successfully fetched the list from category",2,categoryDAO.list().size());
		
		
		
	}*/
	
	
	@Test 
	public void testCRUSCategory() 
	
	{
		
		
		
	}
	
	
}
