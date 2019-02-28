package com.easyget.configuration;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.easyget.interceptor.BackInterceptor;
import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by 李思鸽 on 2017/3/22 0022.
 * WEB MVC配置
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration backInterceptor = registry.addInterceptor(new BackInterceptor());
        backInterceptor.addPathPatterns("/*", "/**");
        backInterceptor.excludePathPatterns("/user/login", "/captcha.svl", "/user/loginSubmit", "/error","/druid/*");
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置默认跳转页面
        registry.addViewController("/").setViewName("forward:/user/login");
        // 设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 设定支持的请求类型
        List<MediaType> mediaTypes = Lists.newArrayList();
        // 自定义新的请求类型
        mediaTypes.add(MediaType.parseMediaType("text/json;charset=UTF-8"));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(fastJsonHttpMessageConverter);
        super.configureMessageConverters(converters);
    }
}
