package com.easyget.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class QueueConsumer {
    private static Logger logger = LoggerFactory.getLogger(QueueConsumer.class);

    @JmsListener(destination = "")
    public void receiveQueue(String text) {
        logger.info("Consumer收到的报文为:"+text);
    }


}
