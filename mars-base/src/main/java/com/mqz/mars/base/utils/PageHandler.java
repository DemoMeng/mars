package com.mqz.mars.base.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description 分页工具类
 * @About： https://github.com/DemoMeng
 */
public class PageHandler {

    public static <T> PageInfo<T> pageList(List<T> list, Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum, pageSize); //创建Page类
        page.setTotal(list.size());// 为Page类中的total属性赋值
        int startIndex = (pageNum - 1) * pageSize; //计算当前需要显示的数据下标起始值
        int endIndex = Math.min(startIndex + pageSize, list.size());
        if(startIndex <= list.size() && endIndex <= list.size()){
            page.addAll(list.subList(startIndex,endIndex));//从链表中截取需要显示的子链表，并加入到Page
            PageInfo pageInfo = new PageInfo<>(page);
            return pageInfo;
        }else{
            return null;//TODO 或者抛出自定义异常
        }
    }

}
