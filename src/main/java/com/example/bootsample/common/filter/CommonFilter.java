package com.example.bootsample.common.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class CommonFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CommonFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("========== CommonFilter.init ==========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("========== CommonFilter.deFilter before ==========");

        filterChain.doFilter(servletRequest, servletResponse);

        logger.info("========== CommonFilter.doFilter after ==========");
    }

    @Override
    public void destroy() {
        logger.info("========== CommonFilter.destroy ==========");
    }

}
