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
public class ParamValidException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -8171188744290010026L;

    private String msg;

    public ParamValidException(){}

    public ParamValidException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
