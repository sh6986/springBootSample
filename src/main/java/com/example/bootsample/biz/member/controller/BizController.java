package com.example.bootsample.biz.member.controller;

import com.example.bootsample.biz.member.service.IBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BizController {

    @Autowired
    IBizService bizService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTest() {

        return bizService.getTest();
    }
}
