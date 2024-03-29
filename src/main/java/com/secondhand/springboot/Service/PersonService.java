package com.secondhand.springboot.Service;

import com.secondhand.springboot.Utils.UuidUtil;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;
import com.secondhand.springboot.mapper.PersonMapper;
import com.secondhand.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.UUID;

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

    public Person getPersonById(String id){
        return personMapper.getPersonById(id);
    }

	public boolean updatePerson(Person person) {
		return personMapper.updatePerson(person)>0?true:false;
	}

	public boolean insertPerson(Person per) {
		UuidUtil util=new UuidUtil();
		per.setId(util.personUuid());
        per.setName(("user_"+ UUID.randomUUID().toString()).substring(0,10));
		per.setFlag(0);
		per.setSex(true);
		return personMapper.insertPerson(per)>0?true:false;		
	}

	public String getPersonIdByUserId(String userId){
        return userMapper.getPerIdByUserId(userId);
    }
}
