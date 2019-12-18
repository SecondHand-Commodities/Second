package com.secondhand.springboot.Service;

import com.secondhand.springboot.Utils.DiffName;
import com.secondhand.springboot.Utils.UuidUtil;
import com.secondhand.springboot.bean.Products;
import com.secondhand.springboot.mapper.PersonMapper;
import com.secondhand.springboot.mapper.ProductsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author rzw
 * @create 2019-12-16-15:00
 */
@Service
public class ProductsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsService.class);
    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private PersonMapper personMapper;

    /**
     * 上传商品
     * @param product
     * @return
     */
    public int upLoadProduct(Products product, String perid,String filePath){
        product.setPid(UuidUtil.proUuid());
        product.setPerId(personMapper.getPersonById(perid));
        product.setpPhoto(filePath);
        product.setpState(0);
        Date date = new Date();
        product.setCreatetime(date);
        LOGGER.info("封装products对象成功");
        return productsMapper.insertProduct(product);
    }

    public String upLoadPhoto(MultipartFile file) {
        if (file.isEmpty()){
            LOGGER.info("上传文件为空，文件上传失败");
            return "上传失败";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D:/software/src/main/resources/static/images/";
        String newFileName = DiffName.namePreffix(fileName);
        File dest = new File(filePath + newFileName);
        try {
            file.transferTo(dest);
            LOGGER.info("文件上传成功");
            return "../images/" + newFileName;
        }catch (IOException e){
            LOGGER.error(e.toString(),e);
        }
        return "上传失败";
    }

    /**
     * 管理员审核商品
     * @param pid
     * @param state
     * @return
     */
    public int checkProduct(String pid,Integer state){
        int result = productsMapper.updateProductState(pid,state);
        if (result == 1)
            LOGGER.info("审核成功");
        else LOGGER.error("审核失败");
        return result;
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
        return  productsMapper.updateProductState(pid,3);
    }

    /**
     * 通过状态查找商品
     * @param state
     * @return
     */
    public List<Products> getProductsByState(Integer state){
        return  productsMapper.getProductsByState(state);
    }

    /**
     * 模糊查询
     * @param keyWord
     * @return
     */
    public List<Products> getProductsByLike(String keyWord){
        keyWord = "%" + keyWord + "%";
        return productsMapper.getProductsByLike(keyWord);
    }
}
