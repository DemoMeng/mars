package com.mqz.mars.validation.exceptions;

import java.io.Serializable;

/**
 * 版权所有  copyright© 蒙大拿
 *
 * @author mqz
 * @date
 * @about https://www.github.com/DemoMeng
 * @description
 */
public class WithoutLoginException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -5395414930731458355L;

    private String msg;

    public WithoutLoginException(){

    }

    public WithoutLoginException(String msg){
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
