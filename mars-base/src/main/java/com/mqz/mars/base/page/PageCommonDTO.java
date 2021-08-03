package com.mqz.mars.base.page;

import lombok.Data;

import java.io.Serializable;

/**
 * 版权所有  copyright© 蒙大拿
 *
 * @author mqz
 * @date
 * @inf mengqizhang
 * @about https://www.github.com/DemoMeng
 * @description
 */
@Data
public class PageCommonDTO implements Serializable {

    /**
     * 每页显示数量
     */
    private Integer pageSize = 10;

    /**
     * 页码
     */
    private Integer pageCurrent = 1;

}
