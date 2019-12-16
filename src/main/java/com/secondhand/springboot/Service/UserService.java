package com.secondhand.springboot.Service;

import com.secondhand.springboot.repository.PersonRepository;
import com.secondhand.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	@Autowired
	PersonRepository personRepository;

	public boolean Regist(User account){
		User accountByUsername = repository.findAccountByUsername(account.getUserName());
		if (!Objects.isNull(accountByUsername))
			return false;
		else {
			Person p = new Person();
			p.setName(("user_"+ UUID.randomUUID().toString()).substring(0,10));
			p.setSex(true);

			personRepository.save(p);
			account.setPerson(p);
			repository.save(account);
			return true;
		}
	}

	public boolean Login(User account){
		User accountByUsernameAndPassword = repository.findAccountByUsernameAndPassword(account.getUserName(), account.getPassword());
		if(Objects.isNull(accountByUsernameAndPassword))
			return false;
		else
			return true;
	}
}
