package com.example.bootsample.view.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view/member")
public class VMemberController {

    @RequestMapping(value = "/login")
    public String login() {
        return "member/login";
    }

}
