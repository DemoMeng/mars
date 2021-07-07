package com.mqz.mars.base.thread;

import java.util.HashMap;
import java.util.Map;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：2021/5/17 4:09 下午
 * @Description
 * @About： https://github.com/DemoMeng
 */
public class LocalContext {

    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new HashMap<String,Object>();
        }
    };

    public static void addAll(HashMap<String,Object> parma){
        threadLocal.get().putAll(parma);
    }

    public static void add(String key,Object value){
        threadLocal.get().put(key,value);
    }

    /**
     * 注意get出的数据类型！！
     * @param key
     * @param clazz
     * @param <V>
     * @return
     */
    public static <V> V get(String key,Class<V> clazz){
        Object value = threadLocal.get().get(key);
        if (value != null && clazz.isInstance(value)){
            return clazz.cast(value);
        }
        return null;
    }

    public static void remove(){
        threadLocal.remove();
    }

}
