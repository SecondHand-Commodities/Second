package com.secondhand.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secondhand.springboot.Service.AdminService;
import com.secondhand.springboot.Service.ProductsService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.Products;
import com.secondhand.springboot.bean.User;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	ProductsService productsService;
	
	
	
	@RequestMapping("/admin")
	public String adminCheck(Model model,HttpServletRequest request) {
    	init(model, request);   
    	List<Products> productsList =new ArrayList<Products>();
    	User user =(User) request.getSession().getAttribute("user");
    	productsList=productsService.getProductsByState(0);
    	model.addAttribute(productsList);
		return "index";
	}
	
	@RequestMapping("/shenghe")
	public String checkProduct(@RequestParam(value="state",defaultValue="0")String state,Model model,HttpServletRequest request) {		
		init(model,request);
		List<Products> productsList =new ArrayList<Products>();
		productsList=productsService.getProductsByState(Integer.parseInt(state));
		model.addAttribute(productsList);
		return "index";		
	}
	
	
	@RequestMapping("/changeState")
	public String changeProductState(@RequestParam(value="pid")String pid,@RequestParam(value="state")String state,Model model,HttpServletRequest request) {		
		init(model,request);
		productsService.checkProduct(pid, Integer.parseInt(state));
		return "index";		
	}
	
	public void init(Model model,HttpServletRequest request) {
		User user =(User) request.getSession().getAttribute("user");
		Person person =adminService.information(user);		
		model.addAttribute("admin", person);
	}
	
	@RequestMapping("/Tuichu")
	public String Tuichu(HttpServletRequest request) {		
		User user = null;
		request.getSession().setAttribute("user",user);
		return "login";		
	}
	
	
}
