package com.ssafy.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/index.php")
    public String index() {
        return "index.html";
    }

    @GetMapping("/list.php")
    public String list() {
        return "list.html";
    }
}
