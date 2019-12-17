package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author rzw
 * @create 2019-12-13-16:54
 */
@Mapper
public interface PersonMapper {

    @Select("select * from person where id = #{id}")
    public Person getPersonById(String id);
    @Insert("insert into person values (#{id},#{name},#{sex},#{tel},#{address},#{flag})")
    public int insertPerson(Person person);
    
    
    @Select ("select count(*) from user where username=#{usename}")
    public int checkUser(String usename);
    
    @Insert ("insert into user values (#{username},#{password})")
    public int insertUserOne(User user);
    
    @Insert ("insert into person values (#{id},#{name},#{sex},#{tel},#{address},#{flag})")
    public int insertPersonOne(Person person);

    @Update("update person set name=#{name},sex=#{sex},tel=#{tel},address=#{address},flag=#{flag}")
    public int updatePerson(Person person);
}
