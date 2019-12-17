package com.secondhand.springboot.mapper;

import com.secondhand.springboot.bean.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author rzw
 * @create 2019-12-17-17:13
 */
@Mapper
public interface OrderMapper {

    @Insert("insert into [order] values (#{oid},#{pid.pid},#{id.id},#{oDate},#{oState})")
    public int addOrder(Order order);
}
