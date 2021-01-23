package net.km.onlineshopping1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.km.onlineshopping1.util.FileUploadUtility;
import net.km.onlineshopping1.validator.ProductValidator;
import net.km.shoppingbackend1.dao.CategoryDAO;
import net.km.shoppingbackend1.dao.ProductDAO;
import net.km.shoppingbackend1.dto.Category;
import net.km.shoppingbackend1.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	
	@Autowired
	private CategoryDAO categoryDAO ;
	
	@Autowired
	private ProductDAO productDAO ;
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView  showManageProducts(@RequestParam(name="operation",required=false) String operation) {		

		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		Product nProduct =new Product();
		//set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		
		mv.addObject("product",nProduct);
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product Submitted Successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully!");
			}
		}
		return mv;
	
	}
	
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView  showEditProduct(@PathVariable int id)
	{
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		//fetch the product from the database 
		Product nProduct=productDAO.get(id);
		//set the product fetched from database
		mv.addObject("product",nProduct);
		return mv;
		
	}
	
	
	
	
	
	
	
	
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results,Model model
			,HttpServletRequest request) {
			if(mProduct.getId()==0) {
				new ProductValidator().validate(mProduct,results);
			}
			else {
				if(!mProduct.getFile().getOriginalFilename().equals(""))
				{
					new ProductValidator().validate(mProduct,results);
				}
			}
		
		
		
		
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			return "page";
			
		}
		logger.info(mProduct.toString());
		
		
		
		if(mProduct.getId()==0)
		{//add new product
			productDAO.add(mProduct);	
		}
		else {
			//update the product
			productDAO.update(mProduct);
		}
		
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		//get the product object
		Product product=productDAO.get(id);
		
		boolean isActive=product.isActive();
		
		product.setActive(!product.isActive());
		productDAO.update(product);
		
		
		
		
		return (isActive)?"You have successfully deactivated the product with ID"+product.getId():
			"You have successfully activated the product with ID"+product.getId();
	}
	
	//handle category submission
	
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		
		
		categoryDAO.add(category);
		
		return "redirect:/manage/products/?operation=category"; 
		
		
	}
	
	
	//returning categories for allrequest mapping
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDAO.list();
	}
	
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}
	
	
	
	
	
	
}
