package com.mqz.mars.base.utils;

import java.util.UUID;


/**
 * 版权所有  copyright© 蒙大拿
 *
 * @author mqz
 * @date
 * @about https://www.github.com/DemoMeng
 * @description
 */
public class UuidUtils {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
