package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @RequestMapping("/dictionary")
    @PostMapping
    public String dictionary(String value,Model model) {
        Map<String , String> dictionary = dictionaryService.search();
        model.addAttribute("dictionary",dictionary);
        model.addAttribute("value", value);
        model.addAttribute("notFound", "không tìm thấy");
        return "/search";
    }

}
