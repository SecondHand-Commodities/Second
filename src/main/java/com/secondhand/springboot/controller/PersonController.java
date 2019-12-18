package com.secondhand.springboot.controller;

import com.secondhand.springboot.Service.PersonService;
import com.secondhand.springboot.Service.UserService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;
import com.secondhand.springboot.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

/**
 * @author rzw
 * @create 2019-12-13-17:10
 */
@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    PersonMapper personMapper;
    @Autowired
    UserService userService;

    @GetMapping("/per/{id}")
    public Person getPerson(@PathVariable("id") String id){
        return personMapper.getPersonById(id);
    }

    @GetMapping("/per")
    public int insertPerson(Person person){
        return personMapper.insertPerson(person);
    }

    /**
     * @author yxn
     * @param person
     * @param request
     * @return
     */
    @PostMapping("/changeInfo")
    public String changeInfo(Person person, HttpServletRequest request){
        personService.changeInfo(person,(String) request.getSession().getAttribute("username"));
        return "修改成功";
    }
    
    @ResponseBody
    @RequestMapping("/updatePerson")
    public String updatePerson(Person per,HttpServletRequest request){
    	Person person=((User) request.getSession().getAttribute("user")).getPerson();
    	person.setAddress(per.getAddress());
    	person.setTel(per.getTel());
    	person.setSex(per.isSex());
    	boolean result =personService.updatePerson(person);
        return "处理成功";
    }
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    public String singUp(User user,Person per,@RequestParam(value="check_password")String check_password){
    	if (!check_password.equals(user.getPassword()))
    		return "俩次密码不正确";
    	boolean resultP =personService.insertPerson(per);
    	boolean resultU =userService.insertUser(per,user);
    	if (resultP&&resultU)
    		return "处理成功";
    	else return "网络原因注册失败";
    }
    
}
