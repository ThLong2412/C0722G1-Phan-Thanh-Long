package com.example.demo.controller;

import com.example.demo.dto.IQuestionContentDetailDto;
import com.example.demo.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/detail/v1")
@CrossOrigin("*")
public class QuestionContentDetailController {
    @Autowired
    private IQuestionContentService questionContentService;

//    @GetMapping("/id")
//    public ResponseEntity<List<IQuestionContentDetailDto>> show(@PathVariable Long id) {
//
//    }
}
