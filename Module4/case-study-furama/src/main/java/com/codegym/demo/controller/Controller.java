package com.codegym.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("")
public class Controller {
    @GetMapping("")
    public String getHome() {
        return "/home";
    }
}
