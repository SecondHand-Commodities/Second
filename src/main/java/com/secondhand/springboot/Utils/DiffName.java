package com.secondhand.springboot.Utils;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author rzw
 * @create 2019-12-18-16:11
 */
public class DiffName {

    public static String namePreffix(String fileName){
        String preffix = RandomStringUtils.randomAlphabetic(5) + fileName;
        return preffix;
    }
}
