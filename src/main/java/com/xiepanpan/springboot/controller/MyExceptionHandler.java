package com.xiepanpan.springboot.controller;

import com.xiepanpan.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 异常处理类
 * @author: xiepanpan
 * @create: 2018-12-10 18:02
 **/
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    public String hanlerException(Exception e, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message","用户出错了");
        request.setAttribute("ext",map);
        return "forward/error";
    }
}
