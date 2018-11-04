package com.segmentfault.springbootlesson5.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-04 15:43
 **/
@WebFilter(servletNames = "myServlet")
public class MyFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        ServletContext servletContext = httpServletRequest.getServletContext();

        servletContext.log("/myservlet was filtered!");

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
