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
    public String convert(@RequestParam(defaultValue = "0") Double usd,@RequestParam(defaultValue = "0") Double vnd ,Model model) {
        Double vndAfter = convertService.convert(usd);
        Double usdAfter = convertService.convert2(vnd);
        model.addAttribute("vndAfter", vndAfter);
        model.addAttribute("vnd", vnd);
        model.addAttribute("usdAfter", usdAfter);
        model.addAttribute("usd", usd);
        return "/list";
    }
}
