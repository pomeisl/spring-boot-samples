package com.pomeisl.samples.jms.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("publish")
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/{message}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String publishString(@PathVariable String message) {
        jmsTemplate.convertAndSend("destination_1", message);

        return "published successfully";
    }

}
