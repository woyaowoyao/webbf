/*
 * File Name: DSSExceptionResolver.java
 * Copyright: Copyright 2016 hdu All Rights Reserved.

 * Description:
 * Author: Pi Chen
 * Create Date: 2016年12月01日

 * Modifier: Pi Chen
 * Modify Date: 2016年12月01日
 * Bugzilla Id:
 * Modify Content:
 */
package cn.edu.hdu.webbf.core.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.hdu.webbf.common.base.BaseController;

/**
 * 异常处理
 *
 * @author Pi Chen
 * @version webbf V1.0.0, 2016年12月01日
 * @see
 * @since webbf V1.0.0
 */
@ControllerAdvice
public class BFExceptionHandler extends BaseController
{

    /**
     * 处理controller抛出的异常
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(HttpServletRequest request, Exception e)
    {
        logger.error("Request FAILD, URL = {} ", request.getRequestURI());
        logger.error(e.toString(), e);
        return gson.toJson(BaseController.FAILD);
    }

    /**
     * 处理controller抛出的异常
     *
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String handleNumberFormatException(HttpServletRequest request, NumberFormatException e)
    {
        logger.error("Request FAILD, URL = {} ", request.getRequestURI());
        logger.error(e.toString(), e);
        return gson.toJson(BaseController.FAILD);
    }

    /* other exception */
}