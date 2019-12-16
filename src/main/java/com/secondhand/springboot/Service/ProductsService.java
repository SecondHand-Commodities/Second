package com.secondhand.springboot.Service;

import com.secondhand.springboot.Utils.UuidUtil;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.Products;
import com.secondhand.springboot.mapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rzw
 * @create 2019-12-16-15:00
 */
@Service
public class ProductsService {
    @Autowired
    private ProductsMapper productsMapper;

    /**
     * 上传商品
     * @param product
     * @return
     */
    public int upLoadProduct(Products product){
        product.setPid(UuidUtil.proUuid());
        return productsMapper.insertProduct(product);
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
