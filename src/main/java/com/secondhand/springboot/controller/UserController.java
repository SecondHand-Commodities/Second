package com.secondhand.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.secondhand.springboot.Service.UserService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/login")
	@ResponseBody
	public String Login(User user , HttpServletRequest request) {

		if(!Objects.isNull(request.getSession().getAttribute("username")))
			return "已登录，请勿重复登陆";
		boolean result = userService.Login(user);
		if(result){
			request.getSession().setAttribute("user",user);
			return "ok";
		}else
			return "用户名或密码错误";
	}
	@ResponseBody
	@PostMapping("/regist")
	public String Regist(User user) {
		boolean result = userService.Regist(user);
		if(result)
			return "注册成功";
		else
			return "账号已存在，请重新输入";
		
	}
}
