package com.secondhand.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

import java.util.List;

@Mapper
public interface AdminMapper {
	@Select("select * from [user],person where [user].username =#{userName} and [user].password=#{password} and person.id=[user].perid")
	public List<Person> information(User admin);

}
