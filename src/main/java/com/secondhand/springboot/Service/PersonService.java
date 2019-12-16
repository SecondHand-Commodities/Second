package com.secondhand.springboot.Service;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;
import com.secondhand.springboot.mapper.PersonMapper;
import com.secondhand.springboot.mapper.UserMapper;
import com.secondhand.springboot.repository.PersonRepository;
import com.secondhand.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author ：杨肖宁
 * @date ：Created in 2019/12/16 20:13
 * @description：
 * @modified By：
 * @version: 1.0$
 */
@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;

    @Autowired
    UserMapper userMapper;
    public boolean changeInfo(Person person, String username){
        User accountByUsername = userMapper.findAccountByUsername(username);
        Person oldPerson=accountByUsername.getPerson();
        for (Field f:
                Person.class.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if(Objects.isNull(f.get(person))){
                    f.set(person,f.get(oldPerson));
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        personMapper.updatePerson(person);
        return true;
    }
}
