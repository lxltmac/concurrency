package com.mmall;

import com.mmall.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/22.
 */
@Slf4j
public class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter,{},{}",Thread.currentThread().getId(),request.getServletPath());
//        request.getSession().getAttribute("user");
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);//如果不想拦截住请求，想单独做数据处理的时候，继续调用filterChain.doFilter保证拦截器执行完请求继续被处理
    }

    @Override
    public void destroy() {

    }
}
