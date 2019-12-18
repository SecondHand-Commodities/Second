package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from [user] where username=#{userName}")
    public User findAccountByUsername(String userName);

    @Insert("insert into [user] values(#{id},#{userName},#{password})")
    public int insert(User user);

    @Select("select * from [user] where userName=#{username} and password=#{password}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "perid",property = "person",one=@One(select = "com.secondhand.springboot.mapper.PersonMapper.getPersonById")),
        @Result(column = "userName",property = "userName"),
        @Result(column = "password",property = "password")
})
    public User findUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    
    @Insert("insert into [user] values(#{[user].id},#{[user].userName},#{[user].password},#{per.id})")
    public int insertUser(User user,Person per);

    @Select("select perid from [user] where id = #{userId}")
    public String getPerIdByUserId(String userId);
}
