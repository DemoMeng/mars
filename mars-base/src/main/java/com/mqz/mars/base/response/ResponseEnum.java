package com.mqz.mars.base.response;
/**
 * 版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021-05-06
 * @Description
 * @About： https://github.com/DemoMeng
 */
public enum ResponseEnum {

    SUCCESS(200,"请求成功"),
    ERROR(500,"请求失败"),
    NOT_FOUND(404,"所请求的资源不存在")
    ;

    private Integer code;
    private String msg;

    ResponseEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
