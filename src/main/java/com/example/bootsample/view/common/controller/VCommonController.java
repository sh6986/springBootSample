package com.example.bootsample.view.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VCommonController {


    @RequestMapping(value = "/{dir}/{file}")
    public String commonView(@PathVariable("dir") String dir, @PathVariable("file")String file) {
        return dir+"/"+file;
    }

    /*@RequestMapping(value = "/")
    public String commonView(@PathVariable("dir") String dir, @PathVariable("file")String file) {
        return "index"
    }*/


}
