package com.easyget.interceptor;

import com.easyget.constants.Constants;
import com.easyget.entity.TSysUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * APP请求拦截处理
 */
public class BackInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        System.out.println(">>>>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        TSysUser sysUser = (TSysUser) request.getSession().getAttribute(Constants.QIANYIDE_SYS_USER);
        if (sysUser == null) {
            PrintWriter out = response.getWriter();
            out.print("<script>window.parent.location.href='/user/login';</script>");
            out.flush();
            return false;
        }
        return true;// 只有返回true才会继续向下执行，返回false取消当前请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        System.out.println(">>>>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        System.out.println(">>>>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
