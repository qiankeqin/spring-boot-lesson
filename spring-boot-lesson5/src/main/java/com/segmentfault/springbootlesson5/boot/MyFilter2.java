package com.segmentfault.springbootlesson5.boot;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-04 17:31
 **/
public class MyFilter2 extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ServletContext servletContext = httpServletRequest.getServletContext();
        String requestURL = httpServletRequest.getRequestURI();
        servletContext.log(requestURL + " ,myfilter2 filtered");

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
