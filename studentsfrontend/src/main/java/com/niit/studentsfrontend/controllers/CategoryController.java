package com.niit.studentsfrontend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.CategoryDao;
import com.niit.backend.dto.Category;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/admin/getCategoryPage",method=RequestMethod.GET)
	public ModelAndView getCategoryPage(){
		ModelAndView mv=new ModelAndView("CategoryPage");
		return mv;
	}
	
	@RequestMapping(value="/admin/addCategoryForm",method=RequestMethod.GET)
	public ModelAndView getCategoryForm(){
		ModelAndView mv=new ModelAndView("AddCategoryForm");
		mv.addObject("categoryObj", new Category());
		return mv;
	
	}
	
	
	@RequestMapping(value="/admin/addCategory",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("categoryObj")Category categoryObj,ModelMap map){
		System.out.println("Adding Category");
		ModelAndView mv=new ModelAndView("AddCategoryForm");
		categoryDao.insertCategory(categoryObj);
		map.addAttribute("message","Category Added Succesfully..");
		return "redirect:viewAllCategories";
	}
	
	@RequestMapping(value="viewAllCategories",method=RequestMethod.GET)
	public ModelAndView viewAllCategories(){
		System.out.println("Adding Category");
		ModelAndView mv=new ModelAndView("ViewAllCategories");
		List<Category> catList=categoryDao.listCategories();
		mv.addObject("catList",catList);
		return mv;
	}
	
}
