package com.easyget.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by dong_jie on 2018-06-28.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Value("${server.context-path}")
    private String adminPath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/"+adminPath+"/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("Content-Type", "Authorization", "Accept", "X-Requested-With", "Cache-control")
                .maxAge(3600);
    }

    //解决静态资源无法访问的问题
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/bootstrap/**")
                .addResourceLocations("classpath:/static/bootstrap/");
        registry.addResourceHandler("/scripts/**")
                .addResourceLocations("classpath:/static/scripts/");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfig.super.configureMessageConverters(converters);
        //创建fastjson转换器实例
        MappingJackson2HttpMessageConverter converter = (MappingJackson2HttpMessageConverter) SpringContextAware.getBean("respMappingJackson2HttpMessageConverter");

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        converter.setObjectMapper(objectMapper);
        converters.add(converter);
    }

    @Bean
    public FilterRegistrationBean threadLocalFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ThreadLocalFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * 防XSS注入
     */
    private class ThreadLocalFilter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            XsslHttpServletRequestWrapper xssRequest = new XsslHttpServletRequestWrapper((HttpServletRequest)request);
            chain.doFilter(xssRequest, response);
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // TODO Auto-generated method stub
        }

        @Override
        public void destroy() {
            // TODO Auto-generated method stub

        }
    }
}
