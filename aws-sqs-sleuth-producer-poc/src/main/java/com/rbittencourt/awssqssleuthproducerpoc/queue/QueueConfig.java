package com.rbittencourt.awssqssleuthproducerpoc.queue;

import brave.Tracer;
import brave.Tracing;
import brave.instrumentation.aws.sqs.SqsMessageTracing;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Autowired
    private Tracer tracer;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        Tracing current = Tracing.current();
        SqsMessageTracing sqsMessageTracing = SqsMessageTracing.create(current);

        AmazonSQSAsync client = AmazonSQSAsyncClientBuilder.standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRequestHandlers(sqsMessageTracing.requestHandler())
                .build();

        return new QueueMessagingTemplate(client);
    }

}
