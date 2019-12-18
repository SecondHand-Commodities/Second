package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Order;
import com.secondhand.springboot.bean.Products;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author rzw
 * @create 2019-12-17-17:13
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into [order] values (#{oid},#{pid.pid},#{id.id},#{oDate},#{oState})")
    public int addOrder(Order order);
    
    @Select("select * from [order],[Products] where [order].id=#{id} and [order].Pid=[Products].Pid")
	public List<Products> selectMyPurchaseProduct(String id);
    
    @Select("select * from [Products] where [Products].id=#{id} and Pstate='3'")
	public List<Products> selectMySaleProductAndSaled(String id);
    
    @Select("select * from [Products] where [Products].id=#{id} and Pstate<'3'")
	public List<Products> selectMySaleProductAndUnSaled(String id);
}
