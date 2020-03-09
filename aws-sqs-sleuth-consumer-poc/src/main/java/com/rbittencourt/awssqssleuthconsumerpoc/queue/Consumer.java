package com.rbittencourt.awssqssleuthconsumerpoc.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbittencourt.awssqssleuthconsumerpoc.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @SqsListener("${app.queue.name}")
    public void receiveMessage(String message) throws JsonProcessingException {
        logger.info("Message received");

        Person person = objectMapper.readValue(message, Person.class);

        logger.info("Message content: " + person);
    }

}
