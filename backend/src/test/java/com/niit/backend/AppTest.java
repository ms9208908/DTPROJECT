package com.niit.backend;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.User;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest {
 	
	static UserDao daoObj;
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		 context.scan("com.onlineshop.BackEnd2");
		 
		 context.refresh();
		 daoObj=context.getBean("userDaoImpl",UserDao.class);
	}


@Test
	public void addUserTest() {
		
		
		Address addr1=new Address();
		addr1.setCity("Delhi");
		addr1.setLocality("patel nagar");
	    addr1.setHouseNumber(2237);
	    addr1.setPinCode(110008);
	    addr1.setBilling(true);
	    addr1.setState("Delhi");
	    
	    Address addr2=new Address();
		addr2.setCity("Delhi");
		addr2.setLocality("Rajouri Garden ");
	    addr2.setHouseNumber(2254);
	    addr2.setPinCode(110010);
	    addr2.setBilling(true);
	    addr2.setState("Delhi");
	
		
		User user=new User();
	//	user.setFirstname("sakshi");
		//user.setLastname("verma");
		//user.setContactNo(789825521l);
		user.setPassword("Sakshi");
		//user.setConfirmpassword("sakshi");
		user.setEmail("sakshi7198@gmail.com");
		user.setRole("User");
		user.setEnabled(true);
		user.getAddresses().add(addr1);
		user.getAddresses().add(addr2);

		addr1.setUser(user);
		addr2.setUser(user);
		 
		System.out.println("I am ADD METHOD");
		
		assertTrue("User added Succesfully" ,daoObj.addUser(user));
	}

@Test
@Ignore
public void getUserByIdTest() {
	
	
	//User user= daoObj.getUserById();
	
	//System.out.println(user.getFirstname()+"" +user.getLastname());
	//assertNull("User Not Found",user);
		
}



}