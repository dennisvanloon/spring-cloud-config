package com.dvl.examples.cloudconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.Executors.newScheduledThreadPool;
import static java.util.concurrent.TimeUnit.SECONDS;

//@Component
@Slf4j
public class MessageLogger {

    @Value("${test.message}")
    private String message;

    public MessageLogger() {
        ScheduledExecutorService scheduledExecutorService = newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(this::logMessage, 5, 5, SECONDS);
    }

    private void logMessage() {
        log.info(message);
    }
}
