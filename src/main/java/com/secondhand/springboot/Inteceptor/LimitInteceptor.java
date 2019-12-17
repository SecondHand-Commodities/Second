package com.secondhand.springboot.Inteceptor;

import com.secondhand.springboot.bean.User;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：杨肖宁
 * @date ：Created in 2019/12/16 21:16
 * @description：
 * @modified By：
 * @version: 1.0$
 */
public class LimitInteceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       
    }@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	 User user = (User) request.getSession().getAttribute("user");
         if(user.getPerson().getFlag()==1){
             response.sendRedirect("admin");
         }
    	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
    
}
