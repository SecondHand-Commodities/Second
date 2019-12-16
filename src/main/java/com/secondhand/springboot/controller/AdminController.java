package com.secondhand.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.secondhand.springboot.Service.AdminService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
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
	System.out.println(user.getUserName());
	Person person =adminService.information(user);		
	model.addAttribute(person);
	return "index";
}
	
}
