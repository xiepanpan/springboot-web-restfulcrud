package com.xiepanpan.springboot.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @description: 自定义错误参数
 * @author: xiepanpan
 * @create: 2018-12-10 17:52
 **/
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String,Object> map =  super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company","xiepanpan");
        //0表示从请求域中取值
        Map<String,Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }
}
