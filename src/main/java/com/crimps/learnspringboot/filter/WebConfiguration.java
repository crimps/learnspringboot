package com.crimps.learnspringboot.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author crimps
 * @create 2017-11-08 10:41
 **/
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean addFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("paramName", "paramValue");
        registrationBean.setName("MyFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            System.out.println("this is MyFilter, url:" + httpServletRequest.getRequestURI());
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }
    }
}
