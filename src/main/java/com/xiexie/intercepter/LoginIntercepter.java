package com.xiexie.intercepter;

import com.alibaba.fastjson.JSON;
import com.xiexie.bean.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserInfo userInfo = (UserInfo) httpServletRequest.getSession().getAttribute("userInfo");
        if (null == userInfo){
            // 不能让你 看， 直接拦截
            System.out.println("没有有session，拦截");
            Map codeMap = new HashMap<>();
            codeMap.put("code",-1);
            codeMap.put("msg","您没有登陆，不可以方法问");
            String json = JSON.toJSONString(codeMap);
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter writer = httpServletResponse.getWriter();
            writer.print(json);
            writer.flush();
            writer.close();
            return false ;
        }else{
            System.out.println("有session，放行");
            return  true ;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
