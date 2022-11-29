package com.example.demo.controller;

import com.example.demo.model.Music;
import com.example.demo.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String home(Pageable pageable, Model model) {
        Page<Music> musicPage = musicService.findAll(pageable);
        model.addAttribute("music", new Music());
        model.addAttribute("musicPage", musicPage);
        return "/home";
    }

    @GetMapping("/create")
    public String showFormCreate(Pageable pageable, Model model) {
        model.addAttribute("music", new Music());
        model.addAttribute("message", "Successfully music added new");
        return "/create";
    }

    @PostMapping("/save")
    public String saveMusic(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        musicService.save(music);
        return "redirect:/music";
    }
}
