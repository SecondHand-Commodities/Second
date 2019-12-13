package com.secondhand.springboot.controller;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rzw
 * @create 2019-12-13-17:10
 */
@RestController
public class PersonController {
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
}
