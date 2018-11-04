package com.segmentfault.springbootlesson5.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-04 15:16
 **/
@WebServlet(
        name="myServlet",
        urlPatterns = {"/myServlet"},
        initParams = {
                @WebInitParam(name="myvalue",value="China")
        }
)
public class MyServlet extends HttpServlet{

    private String value;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String myvalue = config.getInitParameter("myvalue");
        value = myvalue;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body><h1>hello world</h1><h2>value="+value+"</h2></body></html>");
    }
}
