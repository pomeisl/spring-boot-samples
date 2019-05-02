package com.pomeisl.samples.jms.activemq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "destination_1")
    public void listener(String message) {
        jmsTemplate.convertAndSend("destination_2", message.toUpperCase());
    }
}
