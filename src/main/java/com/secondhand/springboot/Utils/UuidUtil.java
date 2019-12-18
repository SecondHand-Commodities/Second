package com.secondhand.springboot.Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成各个表的主键的自增长
 * @author rzw
 * @create 2019-12-15-17:21
 */
public class UuidUtil {

    /**
     * 生成user的主键
     * @return
     */
    public static String userUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomAlphabetic(4);
        String id = "user" + format.format(now) + suffix;
        return id;
    }

    /**
     * 生成产品的主键
     * @return
     */
    public static String proUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomAlphabetic(5);
        String id = "pro" + format.format(now) + suffix;
        return id;
    }

    /**
     * 生成订单的主键
     * @return
     */
    public static String ordUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomAlphabetic(5);
        String id = "ord" + format.format(now) + suffix;
        return id;
    }

    /**
     * 生成评论的主键
     * @return
     */
    public static String comUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomAlphabetic(5);
        String id = "com" + format.format(now) + suffix;
        return id;
    }
    
    /**
     * 生成person的主键
     * @return
     */
    public static String personUuid(){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String suffix = RandomStringUtils.randomAlphabetic(4);
        String id = "pers" + format.format(now) + suffix;
        return id;
    }

}
