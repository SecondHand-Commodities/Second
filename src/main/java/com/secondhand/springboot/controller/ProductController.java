package com.secondhand.springboot.controller;

import com.secondhand.springboot.Service.ProductsService;
import com.secondhand.springboot.bean.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author rzw
 * @create 2019-12-15-16:02
 * 关于商品的服务
 */
@Controller
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping("addProduct")
    public String addProduct(@RequestParam("file") MultipartFile file, Products products, HttpSession session){
        String filePath = productsService.upLoadPhoto(file);
//        String perid = (String) session.getAttribute("user");
        String perid = "user123456789098";
        productsService.upLoadProduct(products,perid,filePath);
        return "success";
    }
    @RequestMapping("test")
    public String kk(){
        return "addProduct";
    }
}
