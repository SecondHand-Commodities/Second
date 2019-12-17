package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from [user] where username=#{userName}")
    public User findAccountByUsername(String userName);

    @Insert("insert into [user] values(#{id},#{username},#{password})")
    public int insert(User user);

    @Select("select * from [user] where userName=#{username} and password=#{password}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "perid",property = "person",one=@One(select = "com.secondhand.springboot.mapper.PersonMapper.getPersonById")),
        @Result(column = "userName",property = "userName"),
        @Result(column = "password",property = "password")
})
    public User findUserByUsernameAndPassword(String username,String password);
    
}
