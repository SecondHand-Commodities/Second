package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.Products;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author rzw
 * @create 2019-12-15-14:59
 */
@Mapper
public interface ProductsMapper {

    @Select("select * from products where ostate = 1")
    public List<Products> getAllProducts();

    @Select("select * from products where pid = #{pid}")
    public Products getProductById(String pid);

    @Update("update products set pstate = #{state} where pid = #{pid}")
    public int updateProductState(String pid,Integer state);

    @Insert("insert into products values(#{product.pid},#{product.perId},#{product.pname},#{product.pprice},#{product.pphoto},#{product.pstate},#{product.pdescription})")
    public int insertProduct(Products product);

    @Select("select * from products where ostate = #{state}")
    public List<Products> getProductsByState(Integer state);
}
