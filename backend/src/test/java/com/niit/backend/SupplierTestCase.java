package com.niit.backend;



import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.SupplierDao;
import com.niit.backend.dto.Supplier;

public class SupplierTestCase {
	
	static SupplierDao supplierObj;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.niit.backend");
		app.refresh();
		supplierObj=app.getBean("supplierDao",SupplierDao.class);
	}
	
	@Test
	@Ignore
	public void addSupplier(){
		Supplier sup=new Supplier();
		sup.setSupplierName("Caprese Bags");
		
		
		assertTrue("Supplier Not Added Succesfully",supplierObj.insertSupp(sup));
	}
	
	@Test
	public void fetchAllCategories(){
		//TEst Case
	}
}







