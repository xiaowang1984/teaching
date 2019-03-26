package com.neuedu.config;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.message.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        if(httpServletRequest.getSession().getAttribute("user")!=null)
//            return true;
//        else{
//           JSONObject jsonObject = new JSONObject();
//           httpServletResponse.setCharacterEncoding("UTF-8");
//            httpServletResponse.getWriter().print(JSONObject.toJSONString(new Message(-1,"会话已经丢失")) );
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
