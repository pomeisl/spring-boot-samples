package com.pomeisl.samples.jms.activemq;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootJmsActivemqApplication.class)
public class JmsTemplateTest {

    @Autowired
    JmsTemplate jmsTemplate;

    @Test
    public void whenMessageSent_thenReceivedOnTheOtherDestination() {
        jmsTemplate.convertAndSend("destination_1", "message");

        Assertions.assertThat(jmsTemplate.receiveAndConvert("destination_2")).isEqualTo("MESSAGE");
    }
}
