package com.secondhand.springboot.Service;
import com.secondhand.springboot.mapper.PersonMapper;
import com.secondhand.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PersonMapper personMapper;

	public boolean Regist(User account){
		User accountByUsername = userMapper.findAccountByUsername(account.getUserName());
		if (!Objects.isNull(accountByUsername))
			return false;
		else {
			Person p = new Person();
			p.setName(("user_"+ UUID.randomUUID().toString()).substring(0,10));
			p.setSex(true);
			personMapper.insertPerson(p);
			account.setPerson(p);
			userMapper.insert(account);
			return true;
		}
	}

	public boolean Login(User account){
		User accountByUsernameAndPassword = userMapper.findUserByUsernameAndPassword(account.getUserName(), account.getPassword());
		if(Objects.isNull(accountByUsernameAndPassword))
			return false;
		else
			return true;
	}
	
	public User selectByNameAndPassword(User account){		 
		return userMapper.findUserByUsernameAndPassword(account.getUserName(), account.getPassword());
	}
}

