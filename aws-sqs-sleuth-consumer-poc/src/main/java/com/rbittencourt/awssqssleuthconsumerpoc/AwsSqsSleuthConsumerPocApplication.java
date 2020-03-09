package com.rbittencourt.awssqssleuthconsumerpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = ContextInstanceDataAutoConfiguration.class)
public class AwsSqsSleuthConsumerPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsSleuthConsumerPocApplication.class, args);
	}

}
