package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author rzw
 * @create 2019-12-15-14:59
 */
@Mapper
public interface ProductsMapper {

    @Select("select * from products where pstate = 1")
    public List<Products> getAllProducts();

    @Select("select * from products where pid = #{pid}")
    @Results({
            @Result(id = true,column = "Pid",property = "pid"),
            @Result(column = "perid",property = "perId",one=@One(select = "com.secondhand.springboot.mapper.PersonMapper.getPersonById")),
            @Result(column = "Pname",property = "pName"),
            @Result(column = "Pprice",property = "pPrice"),
            @Result(column = "Pphoto",property = "pPhoto"),
            @Result(column = "Pstate",property = "pState"),
            @Result(column = "Pdescription",property = "pDescription"),
            @Result(column = "createtime",property = "createtime")
    })
    public Products getProductById(String pid);

    @Update("update products set pstate = #{state} where pid = #{pid}")
    public int updateProductState(@Param("pid") String pid,@Param("state") Integer state);

    @Insert("insert into products values(#{pid},#{perId.id},#{pName},#{pPrice},#{pPhoto},#{pState},#{pDescription},#{createtime})")
    public int insertProduct(Products products);

    @Select("select * from products where pstate = #{state}")
    public List<Products> getProductsByState(Integer state);
}
