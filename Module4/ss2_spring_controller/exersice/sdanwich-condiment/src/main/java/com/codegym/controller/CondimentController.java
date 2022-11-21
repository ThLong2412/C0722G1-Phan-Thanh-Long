package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/condiment")
public class CondimentController {
    @GetMapping("")
    public String getIndex() {
        return "/index";
    }

    @PostMapping("")
    public String save(@RequestParam String [] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "/index";
    }
}
