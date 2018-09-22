package com.niit.backend;



import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.CategoryDao;
import com.niit.backend.dto.Category;

public class CategoryTestCase {
	
	static CategoryDao categoryObj;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.niit.backend");
		app.refresh();
		categoryObj=app.getBean("categoryDao",CategoryDao.class);
	}
	
	@Test
	@Ignore
	public void addCategory(){
		Category cat=new Category();
		cat.setCategoryName("Beauty");
		
		
		assertTrue("Category Not Added Succesfully",categoryObj.insertCategory(cat));
	}
	
	@Test
	public void fetchAllCategories(){
		//TEst Case
	}
}







