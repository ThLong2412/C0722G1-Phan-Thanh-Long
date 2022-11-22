package com.codegym.controller;

import com.codegym.model.Mailbox;
import com.codegym.service.IMailboxService;
import com.codegym.service.impl.MailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller

public class MailboxController {
    @Autowired
    private IMailboxService mailboxService;

    List<String> languageList = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
    List<Integer> pageSizeList = Arrays.asList(5, 10, 15, 20, 25, 100);
    List<Boolean> spamsFilterList = Arrays.asList(true, false);

    @GetMapping("home")
    public String home(Model model) {
        List<Mailbox> mailboxList = mailboxService.show();
        model.addAttribute("mailboxList", mailboxList);
        return "/home";
    }

    @GetMapping("show")
    public String showForm(@RequestParam(required = false) Integer id, Model model) {
        Mailbox mailbox = mailboxService.showById(id);
        model.addAttribute("mailbox", mailbox);
        model.addAttribute("id", id);
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("spamsFilterList", spamsFilterList);
        return "/show";
    }

    @GetMapping("edit")
    public String showFormEdit(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Mailbox mailbox = mailboxService.showById(id);
        model.addAttribute("mailbox", mailbox);
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("spamsFilterList", spamsFilterList);
        return "/edit";
    }

    @PostMapping("edit")
    public String edit(Mailbox mailbox, RedirectAttributes redirectAttributes) {
        mailboxService.update(mailbox);
        redirectAttributes.addFlashAttribute("mess", "Cập nhật thành công");
        return "redirect:/home";
    }

}
