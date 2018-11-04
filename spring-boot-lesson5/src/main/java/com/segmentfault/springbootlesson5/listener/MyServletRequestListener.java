package com.segmentfault.springbootlesson5.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-04 16:03
 **/
@WebListener
public class MyServletRequestListener implements ServletRequestListener{

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext = servletRequest.getServletContext();
        servletContext.log("listener destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        ServletContext servletContext = servletRequest.getServletContext();
        servletContext.log("listener initialized");
    }


}
