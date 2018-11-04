package com.segmentfault.springbootlesson5;

import com.segmentfault.springbootlesson5.boot.MyFilter2;
import com.segmentfault.springbootlesson5.boot.MyServlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.segmentfault.springbootlesson5"})
public class SpringBootLesson5Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson5Application.class, args);
	}


	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

		servletRegistrationBean.setServlet(new MyServlet2());
		servletRegistrationBean.addUrlMappings("/spring-boot/myservlet2");
		servletRegistrationBean.setName("my-servlet2");
		servletRegistrationBean.addInitParameter("servlet2name","hallo win");

		return servletRegistrationBean;
	}


	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

		filterRegistrationBean.setFilter(new MyFilter2());
		filterRegistrationBean.addServletNames("my-servlet2");
		filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);

		return filterRegistrationBean;
	}

	/**
	 * 组装工作
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(SpringBootLesson5Application.class);
		return builder;
	}
}
