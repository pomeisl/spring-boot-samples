package com.pomeisl.samples.aop.loggingexecution;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import lombok.val;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleAspectTest {

    @Autowired
    SampleService sampleService;

    private static Logger logger = (Logger) LoggerFactory.getLogger(SampleAspect.class);

    @Mock
    Appender<ILoggingEvent> mockAppender;

    @Captor
    ArgumentCaptor<ILoggingEvent> captorLoggingEvent;


    @Before
    public void setup() {
        logger.addAppender(mockAppender);
    }

    @After
    public void teardown() {
        logger.detachAppender(mockAppender);
    }

    @Test
    public void whenAnnotatedMethodIsExecuted_thenExecutionTimeShouldBeLogged() throws InterruptedException {
        sampleService.doSomething();

        verify(mockAppender, times(1)).doAppend(captorLoggingEvent.capture());

        val loggingEvent = captorLoggingEvent.getValue();

        assertThat(loggingEvent.getFormattedMessage())
                .containsSubsequence("void com.pomeisl.samples.aop.loggingexecution.SampleService.doSomething() executed in", "millis.");
    }

}
