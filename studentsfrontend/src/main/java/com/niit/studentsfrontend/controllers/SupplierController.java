package com.niit.studentsfrontend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.SupplierDao;
import com.niit.backend.dto.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/admin/getSupplierPage",method=RequestMethod.GET)
	public ModelAndView getSupplierPage(){
		ModelAndView mv=new ModelAndView("SupplierPage");
		return mv;
	}
	
	@RequestMapping(value="/admin/addSupplierForm",method=RequestMethod.GET)
	public ModelAndView getSupplierForm(){
		ModelAndView mv=new ModelAndView("AddSupplierForm");
		mv.addObject("supplierObj", new Supplier());
		return mv;
	
	}
	
	
	@RequestMapping(value="/admin/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("SupplierObj")Supplier SupplierObj,ModelMap map){
		System.out.println("Adding Supplier");
		ModelAndView mv=new ModelAndView("AddSupplierForm");
		supplierDao.insertSupp(SupplierObj);
		map.addAttribute("message","Supplier Added Succesfully..");
		return "redirect:viewAllSuppliers";
		
	}
	
	@RequestMapping(value="viewAllSuppliers",method=RequestMethod.GET)
	public ModelAndView viewAllSuppliers(){
		System.out.println("Hello Supplier");
		ModelAndView mv=new ModelAndView("ViewAllSuppliers");
		List<Supplier> catList=supplierDao.listSuppliers();
		mv.addObject("supplierList",catList);
		return mv;
	}
	
}
