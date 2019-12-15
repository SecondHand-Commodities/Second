package com.secondhand.springboot.controller;

import com.secondhand.springboot.Utils.UuidUtil;
import com.secondhand.springboot.bean.Products;
import com.secondhand.springboot.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rzw
 * @create 2019-12-15-16:02
 * 关于商品的服务
 */
@RestController
public class ProductController {
    @Autowired
    private ProductsMapper productsMapper;

    /**
     * 上传商品
     * @param id
     * @param name
     * @param price
     * @param photo
     * @param state
     * @param description
     * @return
     */
    public int upLoadProduct(String id,String name,Double price,String photo,Integer state,String description){
        return productsMapper.insertProduct(UuidUtil.proUuid(),id,name,price,photo,state,description);
    }

    /**
     * 管理员审核商品
     * @param pid
     * @return
     */
    public int checkProduct(String pid){
        return productsMapper.updateProductState(pid,1);
    }
    /**
     * 展示商品列表功能
     * @return
     */
    public List<Products> getAllProducts(){
        return productsMapper.getAllProducts();
    }

    /**
     * 展示商品的具体的信息
     * @param pid
     * @return
     */
    public Products getProduct(String pid){
        return productsMapper.getProductById(pid);
    }

    /**
     * 购买商品，将商品的状态更改成2（已售状态）
     * @param pid
     * @return
     */
    public int purchase(String pid){
        return  productsMapper.updateProductState(pid,2);
    }


}
