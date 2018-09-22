package com.niit.studentsfrontend.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.User;



@Controller
public class PageController {
	
	@Autowired
	UserDao userDao;

	@Autowired
	ProductDao productDao;
	
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;

	@RequestMapping(value={"/","/home"},method=RequestMethod.GET)
	public String getHomePage(){
		System.out.println("I m here in getHome Page method");
		Principal principal = request.getUserPrincipal();
		
		
		System.out.println("PRINCIPAL IS  NOT ACTIVE " + principal);
		
		if(principal!=null){
			String userEmail = principal.getName();
			System.out.println("PRINCIPAL IS ACTIVE " + userEmail);
			User user=userDao.getUserById(userEmail);
			System.out.println("Object of User = "+user);
			session.setAttribute("userName", user.getName());
			session.setAttribute("userEmail", user.getEmail());
		}
		
		return "HomePage";

	}
	
	
	
	@RequestMapping(value="/getProductPage",method=RequestMethod.GET)
	public String getProductOptions(){
		return "ProductPage";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLoginForm(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout){
		System.out.println("I m in getLogin Form method");
		ModelAndView mv=new ModelAndView("login");
		if(error!=null){
			mv.addObject("message","Username or password is incorrect");
		}
		if(logout!=null){
			mv.addObject("message","User has succesfully logged out!!");
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView getSignUpForm(){
		ModelAndView mv=new ModelAndView("SignUpForm");
		mv.addObject("userObj",new User());
		return mv;
	}
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUserProcess(@ModelAttribute("userObj")User userObj
			,ModelMap map){
		try{
		userObj.setRole("USER");
		userObj.setEnabled(true);
		userDao.registerUser(userObj);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		map.addAttribute("message","User Registered Succesfully..");
		return "login";
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Aha! Caught You.");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		//first we are going to fetch the authentication
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/login?logout";
	}
	@RequestMapping(value="/getProduct/{category}",method=RequestMethod.GET)
	public ModelAndView getProductsByCategory(@PathVariable("category")String cat){
		System.out.println("Category : "+cat);
		ModelAndView mv=new ModelAndView("ViewAllProductsPage");
		mv.addObject("productList",productDao.getProducts(cat));
		return mv;
	}
}
