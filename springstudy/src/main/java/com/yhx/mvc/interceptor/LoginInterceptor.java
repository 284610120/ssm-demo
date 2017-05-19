package com.yhx.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
    过滤器和拦截器的区别：
 　　①拦截器是基于Java的反射机制的，而过滤器是基于函数回调。
 　　②拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
 　　③拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
 　　④拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
 　　⑤在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
 　　⑥拦截器可以获取IOC容器中的各个bean，而过滤器就不行，这点很重要，在拦截器里注入一个service，可以调用业务逻辑。
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的URL
        String url = request.getRequestURI();
        System.out.println("走拦截器:" + url + ":" + url.contains("/hello/login"));
        if(url.contains("/hello/login")) {
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("user");
        if(username != null) return true;
        //不符合条件的，跳转到登录界面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
