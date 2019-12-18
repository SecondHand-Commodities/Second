package com.secondhand.springboot.Service;

import com.secondhand.springboot.Utils.UuidUtil;
import com.secondhand.springboot.bean.Order;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.Products;
import com.secondhand.springboot.mapper.OrderMapper;
import com.secondhand.springboot.mapper.ProductsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author rzw
 * @create 2019-12-17-17:25
 */
@Transactional
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsService.class);
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductsMapper productsMapper;

    public int addOrder(Products pid, Person person){
        Order order = new Order();
        order.setOid(UuidUtil.ordUuid());
        order.setPid(pid);
        order.setId(person);
        Date date = new Date();
        order.setoDate(date);
        order.setoState(0);
        try {
            int result1 = orderMapper.addOrder(order);
            if (result1 == 1)
                LOGGER.info("生成订单成功");
            int result2 = productsMapper.updateProductState(pid.getPid(),3);
            if (result2 == 1)
                LOGGER.info("修改商品状态成功");
        }catch (Exception e){
            LOGGER.error(e.toString(),e);
            LOGGER.error("添加订单失败");
        }

        return 1;
    }
    
    public List<Products> selectMyPurchaseProduct(String id) {
    	return orderMapper.selectMyPurchaseProduct(id);  	
    }
    
    public List<Products> selectMySaleProductAndSaled(String id) {
    	return orderMapper.selectMySaleProductAndSaled(id);  	
    }
    
    public List<Products> selectMySaleProductAndUnSaled(String id) {
    	return orderMapper.selectMySaleProductAndUnSaled(id);  	
    }
}
