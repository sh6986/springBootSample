package com.example.bootsample.common.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public void exCheck() {
        // TODO : res return
        logger.info("========== Exception ==========");
    }
}
