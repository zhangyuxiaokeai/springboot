package com.atguigu.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//@WebFilter(urlPatterns = {"images/*"})
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("myfilter初始化");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("myfilter初始化doFilter");
    }

    @Override
    public void destroy() {

        log.info("myfilter初始化destroy");
    }
}
