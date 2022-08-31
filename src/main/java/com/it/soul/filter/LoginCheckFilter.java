package com.it.soul.filter;

import com.alibaba.fastjson.JSON;
import com.it.soul.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();
        //log.info(requestURI);

        String[] urls = new String[]{
                "/customer/login",
                "/customer/logout",
                "/customer/check",
                "/homepage.html",
                "/register.html",
                "/login.html",
                "/js/**",
                "/image/**",
                "/css/**",
                "/product/**",
        };

        for(String url: urls){
            if(PATH_MATCHER.match(url, requestURI)){
                //log.info("public resource: {}", requestURI);
                filterChain.doFilter(request,response);
                return;
            }
        }

        if(request.getSession().getAttribute("customer") != null){
            Long id = (Long)request.getSession().getAttribute("customer");
            log.info("customer logged in: {}", id);
            filterChain.doFilter(request,response);
            return;
        }

        response.getWriter().write(JSON.toJSONString(R.error("NOT LOGIN")));
    }
}
