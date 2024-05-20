package com.xiexie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/{path}")
    public String path(@PathVariable(value = "path")  String path ){
        return path ;
    }
}
