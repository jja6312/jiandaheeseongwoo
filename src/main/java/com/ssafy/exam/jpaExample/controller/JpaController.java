package com.ssafy.exam.jpaExample.controller;

import com.ssafy.exam.jpaExample.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {
    @Autowired
    private JpaService jpaService;

    @GetMapping("jpa")
    public void go(){
        jpaService.go();
    }
}
