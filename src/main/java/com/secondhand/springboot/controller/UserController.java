package com.secondhand.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.secondhand.springboot.Service.UserService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("")
	public boolean Login(@RequestParam(value="usename")String usename,@RequestParam(value="password")String password) {
		return userService.Login(usename, password);
	}
	
	public boolean Regist(User user,Person person ,@RequestParam(value="confirmPassword")String confirmPassword) {
		return userService.Regist(user, person,confirmPassword);
		
	}
}
