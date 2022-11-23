package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import com.codegym.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
   private ICalculatorService calculatorService;

    @GetMapping("")
    public String getIndex() {
        return "/index";
    }
    @PostMapping("")
    public String function(@RequestParam ("value1") Double value1,
                           @RequestParam ("value2") Double value2,
                          @RequestParam ("func") String func,
                           Model model) {
        Double result = calculatorService.func(value1,value2,func);
        model.addAttribute("result", result);
        model.addAttribute("value1", value1);
        model.addAttribute("value2", value2);
        return "/index";
    }
}
