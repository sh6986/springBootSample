package com.example.bootsample.common.interceptor;

import com.example.bootsample.biz.member.model.MemberDTO;
import com.example.bootsample.common.config.WebConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommonInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("========== CommonInterceptor.preHandle ==========");

        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberInfo");

        if (null == memberDTO) {

            StringBuffer redirectUrl = new StringBuffer();
            redirectUrl.append(request.getScheme()).append("://")
                       .append(request.getServerName()).append(":")
                       .append(request.getServerPort()).append("/")
                       .append(request.getContextPath())
                       .append("view/member/login");

            response.sendRedirect(redirectUrl.toString());
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("========== CommonInterceptor.postHandle ==========");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("========== CommonInterceptor.afterCompletion ==========");
    }
}
