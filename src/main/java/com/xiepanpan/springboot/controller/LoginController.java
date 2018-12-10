package com.xiepanpan.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @description: 登录控制层
 * @author: xiepanpan
 * @create: 2018-12-05 17:51
 **/
@Controller
public class LoginController {


    /**
     * 登录功能实现  PostMapping表示post请求
     * @param username
     * @param password
     * @param map
     * @return
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password,
                        Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)) {
            session.setAttribute("username",username);
            //登录成功 防止表单重复提交 重定向到表单
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
