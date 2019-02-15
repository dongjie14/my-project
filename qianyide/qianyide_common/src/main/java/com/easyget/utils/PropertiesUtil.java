package com.easyget.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取config.properties配置
 *
 * @author LTQ
 */
public class PropertiesUtil {

    private static Properties properties = new Properties();
    private static WebApplicationContext webApplicationContext;

    static {
        webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        InputStream in = PropertiesUtil.class.getResourceAsStream("/config/config.properties");

        try {
            if (in != null) {
                properties.load(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            value = value.trim();
        }
        return value;
    }
}
