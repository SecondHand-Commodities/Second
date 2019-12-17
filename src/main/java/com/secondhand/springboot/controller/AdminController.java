package com.secondhand.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//	public String adminCheck(User admin,Model model) {
//		
//		Person person =adminService.information(admin);		
//		model.addAttribute(person);
//		return "index";
//	}
	public String adminCheck(Model model) {
		User user =new User();
		user.setUserName("admin");
		user.setPassword("admin");
		Person person =adminService.information(user);		
		model.addAttribute("admin", person);
		return "index";
	}
	
	@RequestMapping("/shenghe")
	public String checkProduct(@RequestParam(value="state",defaultValue="0")String state,Model model) {		
		User user =new User();
		user.setUserName("admin");
		user.setPassword("admin");
		Person person =adminService.information(user);		
		model.addAttribute("admin", person);
		List<Products> productsList =new ArrayList<Products>();
		productsList=productsService.getProductsByState(Integer.parseInt(state));
		model.addAttribute(productsList);
		System.out.println(productsList.get(0).getpName());
		return "index";		
	}
	
	
}
