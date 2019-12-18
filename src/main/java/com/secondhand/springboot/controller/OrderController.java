package com.secondhand.springboot.controller;

import com.secondhand.springboot.Service.OrderService;
import com.secondhand.springboot.Service.PersonService;
import com.secondhand.springboot.Service.ProductsService;
import com.secondhand.springboot.bean.Person;
import com.secondhand.springboot.bean.Products;
import com.secondhand.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author rzw
 * @create 2019-12-17-17:27
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProductsService productsService;
    /**
     *
     * @param session
     * @param pid
     * @return
     */
    @RequestMapping("addOrder/{pid}")
    public String addOrder(HttpSession session, @PathVariable("pid") String pid){
//        String perid = "user123456789098";
        User user = (User) session.getAttribute("user");
        Person person = user.getPerson();
        Products product = productsService.getProduct(pid);
        orderService.addOrder(product,person);
        return "redirect:/getAllProducts";
    }
}
