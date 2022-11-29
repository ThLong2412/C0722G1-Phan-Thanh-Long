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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    public String showFormCreate(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/save")
    public String saveMusic(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Successfully music added new");
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
       Optional<Music> music = musicService.findByTd(id);
        model.addAttribute("music", music.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("music") Music music, Model model, RedirectAttributes redirectAttributes) {
        musicService.save(music);
        model.addAttribute("music", music);
        redirectAttributes.addFlashAttribute("message", "Successfully music update");
        return "redirect:/music";
    }
}
