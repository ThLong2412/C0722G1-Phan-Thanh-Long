package com.example.demo.controller;

import com.example.demo.dto.QuestionContentDto;
import com.example.demo.model.QuestionContent;
import com.example.demo.model.QuestionType;
import com.example.demo.model.Status;
import com.example.demo.service.IQuestionContentService;
import com.example.demo.service.IQuestionTypeService;
import com.example.demo.service.IStatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class QuestionContentController {
    @Autowired
    private IQuestionContentService questionContentService;
    @Autowired
    private IQuestionTypeService questionTypeService;
    @Autowired
    private IStatusService statusService;

    @GetMapping("")
    public String getHome(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String questionTypeId, @PageableDefault(page = 0, size = 3) Pageable pageable, Model model) {
        Page<QuestionContent> questionContentPage = questionContentService.search(pageable, title, questionTypeId);
        List<QuestionType> questionTypeList = questionTypeService.findAll();
        List<Status> statusList = statusService.findAll();
        model.addAttribute("questionContentPage", questionContentPage);
        model.addAttribute("questionTypeList", questionTypeList);
        model.addAttribute("statusList", statusList);
        model.addAttribute("questionContent", new QuestionContent());
        model.addAttribute("questionContentDto", new QuestionContentDto());
        return "/list";
    }

    @PostMapping("save")
    public String create(@Validated @ModelAttribute("questionContentDto") QuestionContentDto questionContentDto, BindingResult bindingResult, Model model, Pageable pageable) {
        new QuestionContentDto().validate(questionContentDto, bindingResult);
        Page<QuestionContent> questionContentPage;
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", 1);
            questionContentPage = questionContentService.findAll(pageable);
            model.addAttribute("questionContentPage", questionContentPage);
            model.addAttribute("questionTypeList", questionTypeService.findAll());
            model.addAttribute("statusList", statusService.findAll());
            return "/list";
        }
        QuestionContent questionContent = new QuestionContent();
        BeanUtils.copyProperties(questionContentDto, questionContent);
        questionContentService.save(questionContent);
        return "redirect:/";
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute("id") Long id) {
        questionContentService.remove(id);
        return "redirect:/";
    }
}
