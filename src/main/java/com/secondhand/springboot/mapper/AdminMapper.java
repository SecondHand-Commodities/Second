package com.secondhand.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

@Mapper
public interface AdminMapper {
	@Select("select count(1) from user,person where user.username =#{userName} and user.password=#{password} and person.id=user.perid")
	public Person information(User admin);

}
