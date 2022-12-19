package com.example.demo.service.impl;

import com.example.demo.model.QuestionType;
import com.example.demo.repository.IQuestionTypeRepository;
import com.example.demo.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
