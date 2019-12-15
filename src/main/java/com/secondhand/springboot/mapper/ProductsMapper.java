package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author rzw
 * @create 2019-12-15-14:59
 */
@Mapper
public interface ProductsMapper {

    @Select("select * from products")
    public List<Products> getAllProducts();

    @Select("select * from products where pid = #{id}")
    public Products getProductById(String pid);
    
}
