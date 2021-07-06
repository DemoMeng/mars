package com.mqz.mars.base.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021-05-06
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@Accessors(chain = true)
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = 7962517191525428151L;
    /**
     * 状态码值
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 不允许外部new
     */
    private ResponseBean(){}

    public static ResponseBean SUCCESS(Object obj) {
        ResponseBean re = new ResponseBean()
                .setCode(ResponseEnum.SUCCESS.getCode())
                .setMsg(ResponseEnum.SUCCESS.getMsg())
                .setData(obj);
        return re;
    }

    public static ResponseBean SUCCESS() {
        ResponseBean re = new ResponseBean()
                .setCode(ResponseEnum.SUCCESS.getCode())
                .setMsg(ResponseEnum.SUCCESS.getMsg());
        return re;
    }


    public static ResponseBean ERROR() {
        ResponseBean re = new ResponseBean()
                .setCode(ResponseEnum.ERROR.getCode())
                .setMsg(ResponseEnum.ERROR.getMsg());
        return re;
    }

    public static ResponseBean ERROR(Object obj) {
        ResponseBean re = new ResponseBean()
                .setCode(ResponseEnum.ERROR.getCode())
                .setMsg(ResponseEnum.ERROR.getMsg())
                .setData(obj);
        return re;
    }

    public static ResponseBean ERROR(String msg) {
        ResponseBean re = new ResponseBean()
                .setCode(ResponseEnum.ERROR.getCode())
                .setMsg(msg);
        return re;
    }



}
