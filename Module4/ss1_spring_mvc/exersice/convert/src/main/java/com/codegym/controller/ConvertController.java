package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("")
public class ConvertController {
    @Autowired
    private IConvertService convertService;
    @GetMapping("")
    public String convert() {
        return "/list";
    }
    @PostMapping("")
    public String convert(@RequestParam Double usd, Model model) {
        Double vnd = convertService.convert(usd);
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "/list";
    }
}
