package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{userName}")
    public User findAccountByUsername(String userName);

    @Insert("insert into user values(#{id},#{username},#{password})")
    public int insert(User user);

    @Select("select * from user where username=#{username}and password=#{password}")
    public User findUserByUsernameAndPassword(String username,String password);
}
