package com.niit.studentsfrontend.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.AddressDAO;
import com.niit.backend.dao.CartDAO;
import com.niit.backend.dao.ItemDAO;
import com.niit.backend.dao.OrderDAO;
import com.niit.backend.dao.ProductDao;
import com.niit.backend.dao.UserDao;
import com.niit.backend.dto.Address;
import com.niit.backend.dto.Cart;
import com.niit.backend.dto.Item;
import com.niit.backend.dto.Order;
import com.niit.backend.dto.Product;
import com.niit.backend.dto.User;

@Controller
public class CartController {

	@Autowired
	OrderDAO orderDao;
	
	@Autowired
	AddressDAO addressDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CartDAO cartDao;
	
	@Autowired
	ItemDAO itemDao;
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/addToCart/{productId}",method=RequestMethod.GET)
	public String addToCart(@PathVariable("productId")int productId)
	{
		Principal principal = request.getUserPrincipal();
		String userEmail=principal.getName();
		
		System.out.println("User Email = "+userEmail);
		
		Cart cartObj=cartDao.getCartByCustomer(userEmail);
		
		if(cartObj==null){
			Cart cart=new Cart();
			cart.setCustomerId(userEmail);
			cart.setUser(userDao.getUserById(userEmail));
			
			
			Item item=new Item();
			item.setCart(cart);
			item.setCustomerId(userEmail);
			item.setPrice(productDao.getProductById(productId).getPrice());
			item.setProduct(productDao.getProductById(productId));
			item.setQuantity(1);
			
			ArrayList<Item> al=new ArrayList<>();
			al.add(item);
			cart.setItems(al);
			
			cartDao.addCart(cart);
			itemDao.addItem(item);
			System.out.println("Cart Created Succesfully");
			
		}
		else {
			
			System.out.println("Cart is available");
			Product pro=productDao.getProductById(productId);
			
			Item itemObj=itemDao.getItemByProductIdAndCustomerId(productId, userEmail);
			if(itemObj==null){
				System.out.println("New Item");
				Item item=new Item();
				item.setCart(cartObj);
				item.setCustomerId(userEmail);
				item.setPrice(pro.getPrice());
				item.setProduct(pro);
				item.setQuantity(1);
				
				itemDao.addItem(item);
				System.out.println("Item Object added into existing cart");
				
			}
			else {
				itemDao.increaseQuantity(itemObj.getItemId());
			}
			
		}
		return "redirect:viewCart?uEmail="+userEmail;
	}
	@RequestMapping(value="/addToCart/viewCart",method=RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("uEmail")String uEmail)
	{
		System.out.println("uEmail = "+uEmail);
		ModelAndView mv=new ModelAndView("ViewCart");
		Cart cartObj=cartDao.getCartByCustomer(uEmail);
		System.out.println("Cart Obj : "+cartObj );
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		
		for(Item i:items){
			if(i.getQuantity()==0){
				itemDao.deleteItem(i.getItemId());
				items=itemDao.getItemsListByCart(cartObj.getCartId());
			}
		}
		
		mv.addObject("itemsList",items);
		return mv;
	}
	
	
	@RequestMapping(value="/addToCart/makePayment",method=RequestMethod.GET)
	public ModelAndView addressForm(){
		
		String id=request.getUserPrincipal().getName();
		System.out.println("Id = "+id);
		User user=userDao.getUserById(id);
		System.out.println("User ="+user);
		
		Set<Address> addresses=user.getAddresses();
		
		
		
		if(addresses.isEmpty()){
			ModelAndView mv=new ModelAndView("AddressForm");
			mv.addObject("addressObj",new Address());
			return mv;
		}
		else {
		ModelAndView mv=new ModelAndView("ViewAddress");
		mv.addObject("addressList",addresses);
		return mv;
		}
	}
	@RequestMapping(value="/addToCart/addAddress",method=RequestMethod.POST)
	public ModelAndView addAddress(@ModelAttribute("addressObj")Address addrObj){
		
		String id=request.getUserPrincipal().getName();
		User user=userDao.getUserById(id);
	
		addrObj.setUser(userDao.getUserById(id));
		
		addressDao.insertAddress(addrObj);
		
		Set<Address> addresses=user.getAddresses();
		
		
		ModelAndView mv=new ModelAndView("ViewAddress");
		mv.addObject("addressList",addresses);
		return mv;
		
	}
	
	@RequestMapping(value="/addToCart/placeOrder",method=RequestMethod.GET)
	public ModelAndView makePayment(){
		
		Cart cartObj=cartDao.getCartByCustomer(request.getUserPrincipal().getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Item item:items){
			sum=sum+item.getPrice();
		}
		
		ModelAndView mv=new ModelAndView("OrderConfirmation");
		mv.addObject("itemsList",items);
		mv.addObject("totalAmountToPay",sum);
		
		return mv;
	}

	@RequestMapping(value="/addToCart/confirmOrder",method=RequestMethod.GET)
	public ModelAndView confirmOrder(){
		Principal p=request.getUserPrincipal();
		Cart cartObj=cartDao.getCartByCustomer(p.getName());
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Item item:items){
			sum=sum+item.getPrice();
		}
	
		ModelAndView mv=new ModelAndView("PaymentForm");
		mv.addObject("itemsList",items);
		mv.addObject("totalAmountToPay",sum);
		
		Order o=new Order();
		o.setTotalPrice(sum);
		
		List<Address> addrList=new ArrayList<>(userDao.getUserById(p.getName()).getAddresses());
		o.setAddress(addrList.get(0));
		
		o.setUser(userDao.getUserById(p.getName()));
		mv.addObject("orderObj",o);
		return mv;
	}

	@RequestMapping(value="/addToCart/processOrder",method=RequestMethod.POST)
	public ModelAndView processOrder(@ModelAttribute("orderObj")Order orderObj){
		String email=request.getUserPrincipal().getName();
	
		Cart cartObj=cartDao.getCartByCustomer(email);
		List<Item> items=itemDao.getItemsListByCart(cartObj.getCartId());
		double sum=0;
		for(Item item:items){
			sum=sum+item.getPrice();
		}
		
		orderDao.makeOrder(orderObj);
		cartDao.deleteCart(cartObj.getCartId());
		
		ModelAndView mv=new ModelAndView("PaymentSuccess");
		mv.addObject("totalAmountToPay",sum);
		return mv;
	}
	
}






