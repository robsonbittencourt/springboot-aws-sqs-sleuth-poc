package com.rbittencourt.awssqssleuthproducerpoc.api;

import com.rbittencourt.awssqssleuthproducerpoc.model.Person;
import com.rbittencourt.awssqssleuthproducerpoc.queue.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private Producer producer;

    @PostMapping
    public void sendPerson(@RequestBody Person person) {
        logger.info("New person was sent to controller");

        producer.send(person);
    }
}
