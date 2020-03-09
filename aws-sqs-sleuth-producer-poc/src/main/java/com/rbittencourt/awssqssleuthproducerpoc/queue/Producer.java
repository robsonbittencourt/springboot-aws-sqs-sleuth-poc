package com.rbittencourt.awssqssleuthproducerpoc.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private Logger logger = LoggerFactory.getLogger(Producer.class);

    @Value("${app.queue.name}")
    private String queueName;

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    public void send(Object message) {
        logger.info("Sending message to queue");
        messagingTemplate.convertAndSend(queueName, message);
    }

}
