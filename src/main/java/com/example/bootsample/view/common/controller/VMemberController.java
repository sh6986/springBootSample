package com.example.bootsample.view.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view/member")
public class VMemberController {

    @RequestMapping(value = "/join")
    public String join() {
        return "member/join";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "member/login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        return "member/login";
    }
}
