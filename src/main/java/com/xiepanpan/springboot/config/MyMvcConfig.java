package com.xiepanpan.springboot.config;

import com.xiepanpan.springboot.component.LoginHandlerInterceptor;
import com.xiepanpan.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description: 使用WebMvcConfigurerAdapter来扩展springMvc的功能
 * @author: xiepanpan
 * @create: 2018-12-05 15:34
 **/
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 添加视图控制
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/xiepanpan").setViewName("success");
    }

    /**
     * 所有的WebMvcConfigurerAdapter会一起起作用
     * @return
     */
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                //排除登录页面 静态文件springboot已经进行了静态资源映射 排除的路径是有顺序的
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return webMvcConfigurerAdapter;
    }

    /**
     * 注册区域解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
