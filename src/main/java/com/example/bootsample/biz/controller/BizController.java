package com.example.bootsample.biz.controller;

import com.example.bootsample.biz.service.Impl.IBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BizController {

    @Autowired
    IBizService bizService;

    @GetMapping("")
    public String getTest() {

        return bizService.getTest();
    }
}
