package com.easyget.configuration;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActiveMqConfig {

    @Bean
    public ActiveMQConnectionFactory factory(@Value("${spring.activemq.user}") String user,
                                             @Value("${spring.activemq.password}") String password,
                                             @Value("${spring.activemq.broker-url}") String url){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user, password, url);
        //设置信任序列化包集合
        List<String> models = new ArrayList<>();
        models.add("java.lang");
        models.add("java.util");
        models.add("com.easyget.entity");
        factory.setTrustedPackages(models);
        //设置处理机制
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setUseExponentialBackOff(true);//是否在每次尝试重新发送失败后，增长这个等待时间
        redeliveryPolicy.setMaximumRedeliveries(3);//最大重传次数，默认为6次，这里设置为3次
        redeliveryPolicy.setInitialRedeliveryDelay(1000L);//初始重发延迟时间，默认为1秒
        redeliveryPolicy.setBackOffMultiplier(2);//重连时间间隔递增倍数
        factory.setRedeliveryPolicy(redeliveryPolicy);
        return factory;
    }
}