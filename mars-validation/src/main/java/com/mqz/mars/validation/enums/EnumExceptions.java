package com.mqz.mars.validation.enums;
/**
 * 版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2020-05-06
 * @Description
 * @About： https://github.com/DemoMeng
 */
public enum EnumExceptions {

    WITHOUT_LOGIN("WithoutLogin","未登录"),
    SERVICES("Service","业务异常"),
    TIMEOUT("TimeOut","请求已经超时"),
    EXCEPTION("Exception","异常"),
    NULL_POINT("NullPointException","空指针异常"),
    METHOD_NOT_ALLOW("TheRequestMethodIsNotAllow","请求方式不允许"),
    DATA_SOURCE_NOT_EXIST("DataSourceNotExist","当前方法所使用数据源不存在"),
    PARAM_VALID("ParamValid","参数异常"),
    MISSING_PARAMETER("MissingParameter","缺少参数"),
    MISSING_PERMISSION("MissingPermission","尚未拥有该权限"),
    JSON_EXCEPTION("JsonException","JSON参数异常"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION("HttpMediaTypeNotSupportedException","Http媒体类型不支持的异常");


    private String method;
    private String msg;

    EnumExceptions(String method, String msg){
        this.method = method;
        this.msg = msg;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
