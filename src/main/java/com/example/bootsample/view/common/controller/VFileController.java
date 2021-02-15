package com.example.bootsample.view.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view/file")
public class VFileController {

    @RequestMapping(value = "/list")
    public String fileList() {
        return "file/fileList";
    }
}
