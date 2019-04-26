package com.pomeisl.samples.aop.loggingexecution;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @LogExecutionTime
    void doSomething() throws InterruptedException {
        Thread.sleep(2000L);
    }
}
