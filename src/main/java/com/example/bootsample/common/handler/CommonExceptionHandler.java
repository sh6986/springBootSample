package com.example.bootsample.common.handler;

import com.example.bootsample.common.constant.MessageConstants;
import com.example.bootsample.common.model.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

//    @ExceptionHandler(Exception.class)
//    public ResultDTO handleException(Exception ex) {
//        // TODO : res return
//        logger.info("========== Exception ==========");
//        logger.error("Exception error: ", ex);
//
//        return new ResultDTO(MessageConstants.ResponseEnum.SERVER_ERROR);
//    }

    @ExceptionHandler(IllegalStateException.class)
    public ResultDTO handleIllegalStateException(IllegalStateException ex) {

        logger.info("========== IllegalStateException ==========");
        logger.error("IllegalStateException error: ", ex);

        return new ResultDTO(MessageConstants.ResponseEnum.EXCEEDS_FILE_SIZE);
    }

    @ExceptionHandler(Exception.class)
    public ResultDTO handleException(Exception ex) {
        // TODO : res return
        logger.info("========== Exception ==========");
        logger.error("Exception error: ", ex);

        return new ResultDTO(MessageConstants.ResponseEnum.SERVER_ERROR);
    }

}
