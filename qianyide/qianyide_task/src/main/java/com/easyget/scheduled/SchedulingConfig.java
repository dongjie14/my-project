package com.easyget.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务配置类
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "0/10 * * * * ?")
    public void timeTest(){
        logger.info(".................test.................");
    }
}
