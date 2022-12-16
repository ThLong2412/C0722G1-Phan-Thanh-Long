package com.example.demo.controller;

import com.example.demo.dto.SuatChieuDto;
import com.example.demo.model.Phim;
import com.example.demo.model.SuatChieu;
import com.example.demo.service.IPhimService;
import com.example.demo.service.ISuatchieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class SuatChieuController {
    @Autowired
    private ISuatchieuService suatchieuService;
    @Autowired
    private IPhimService phimService;
    @GetMapping("")
    public String home(Model model) {
        List<SuatChieu> suatChieuList = suatchieuService.findAll();
        List<Phim> phimList = phimService.findAll();
        model.addAttribute("suatchieuList", suatChieuList);
        model.addAttribute("phimList", phimList);
        model.addAttribute("suatChieuDto", new SuatChieuDto());
        return "/list";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("suatChieuDto") SuatChieuDto suatChieuDto, BindingResult bindingResult, Model model) {
        new SuatChieuDto().validate(suatChieuDto, bindingResult);
        List<SuatChieu> suatChieuList;
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", 1);
            suatChieuList = suatchieuService.findAll();
            model.addAttribute("suatchieuList", suatChieuList);
            model.addAttribute("phimList", phimService.findAll());
            return "/list";
        }
        SuatChieu suatChieu = new SuatChieu();
        BeanUtils.copyProperties(suatChieuDto, suatChieu);
        suatchieuService.save(suatChieu);
        model.addAttribute("phimList", phimService.findAll());
       return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("maChieuSuat") String maChieuSuat) {
        suatchieuService.remove(maChieuSuat);
        return "redirect:/";
    }
}
