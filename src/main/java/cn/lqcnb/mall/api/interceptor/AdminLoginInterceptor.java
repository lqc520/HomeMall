package cn.lqcnb.mall.api.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Author: Lin QiCheng
 * Date: 2019/8/30 19:11
 * To change this template use File | Settings | File Templates.
 * Description:
 * Modify by:
 */
public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("admin")==null){
            System.out.println("AdminLoginInterceptor.preHandle");
            response.sendRedirect("http://mall.lqcnb.cn/views/user/login.html");
            return false;
        }
        return true;
    }
}
