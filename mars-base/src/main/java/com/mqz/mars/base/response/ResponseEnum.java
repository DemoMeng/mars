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


    /**
     *
     *  状态码区分不同系统异常，方便出问题定位到指定系统
     *
     *  10000 ～ 19999 ： 成功范围
     *  20000 ～ 29999 ： 系统异常范围
     *  30000 ～ 39999 ： 用户系统异常范围
     *  40000 ～ 49999 ： 订单系统异常范围
     *  50000 ～ 59999 ： 评价系统异常范围
     *
     *  .............................等
     */

    SUCCESS(10000,"请求成功"),
    ERROR(20000,"请求失败"),
    NOT_FOUND(20404,"所请求的资源不存在"),
    WITHOUT_LOGIN(20401,"未登陆")
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
