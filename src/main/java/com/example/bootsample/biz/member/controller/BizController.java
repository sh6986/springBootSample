package com.example.bootsample.biz.member.controller;

import com.example.bootsample.biz.member.service.IBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BizController {

    private static final Logger logger = LoggerFactory.getLogger(BizController.class);

    @Autowired
    IBizService bizService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTest() {

        logger.info("========== BizController.getTest ==========");

        return bizService.getTest();
    }

    @RequestMapping(value = "/ex", method = RequestMethod.GET)
    public String exTest() throws Exception {

        logger.info("========== BizController.exTest ==========");

        throw new Exception();
    }


}
