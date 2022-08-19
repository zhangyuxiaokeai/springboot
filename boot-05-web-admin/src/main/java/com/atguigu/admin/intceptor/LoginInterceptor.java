package com.atguigu.admin.intceptor;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查
 * 1,配制好拦截器要拦截那些请求
 * 2.把这些配置器放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //登录检查逻辑
        String requestURI = request.getRequestURI();
        log.info("拦截的请求"+requestURI);
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){

            return true;
        }
        //跳转到登录页
        request.setAttribute("msg","未登录请登录");
//        response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        System.out.println("判断返回");
        return false;
    }

    /**
     * 方法执行以后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染以后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
