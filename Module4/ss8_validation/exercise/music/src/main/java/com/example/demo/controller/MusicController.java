package com.example.demo.controller;

import com.example.demo.dto.MusicDto;
import com.example.demo.model.Music;
import com.example.demo.service.IMusicService;
import org.springframework.beans.BeanUtils;
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
    public String home(@ModelAttribute("music") Music music, Pageable pageable, Model model) {
        Page<Music> musicPage = musicService.findAll(pageable);

        model.addAttribute("musicPage", musicPage);
        return "/home";
    }

    @GetMapping("/create")
    public String showFormCreate(@ModelAttribute("musicDto") MusicDto musicDto) {
        return "/create";
    }

    @PostMapping("/save")
    public String saveMusic(@Validated @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Successfully music added new");
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        Music music = musicService.findByTd(id).get();
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
       new MusicDto().validate(musicDto,bindingResult);
       if (bindingResult.hasFieldErrors()) {
           return "/edit";
       }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Successfully music update");
        return "redirect:/music";
    }
}
