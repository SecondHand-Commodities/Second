package com.secondhand.springboot.mapper;

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

    @Select("select * from products where pid = #{id}")
    public Products getProductById(String pid);

    @Update("update products set pstate = #{state} where pid = #{id}")
    public int updateProductState(String pid,int state);

    @Insert("insert into products values(#{pid},#{id},#{pname},#{pprice},#{pphoto},#{pstate},#{pdescription})")
    public int insertProduct(String pid,String id,String name,Double price,String photo,Integer state,String description);

}
