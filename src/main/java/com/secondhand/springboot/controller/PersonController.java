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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

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
    	boolean result =personService.updatePerson(person);
        return "处理成功";
    }
}
