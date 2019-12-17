package com.secondhand.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.secondhand.springboot.Service.UserService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("login_check")
	public void Login(User user , HttpServletRequest request, HttpServletResponse response) throws IOException {

		if(!Objects.isNull(request.getSession().getAttribute("username")))
			System.out.println("已登录，请勿重复登陆"); 
		boolean result = userService.Login(user);
		Person person =userService.selectByNameAndPassword(user);
		if(result){
			request.getSession().setAttribute("user",user);	
			if (person.getFlag()==1)
				response.sendRedirect("admin");
			else response.sendRedirect("getAllProducts");
		} else			
			response.sendRedirect("login"); 
	}

	@PostMapping("/regist")
	public String Regist(User user) {
		boolean result = userService.Regist(user);
		if(result)
			return "注册成功";
		else
			return "账号已存在，请重新输入";
	}
	
	@RequestMapping("login")
	public String redirctLogin() {
		return "login";
	}
}
