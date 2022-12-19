package com.example.demo.service.impl;

import com.example.demo.model.QuestionContent;
import com.example.demo.repository.IQuestionContentRepository;
import com.example.demo.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository questionContentRepository;
    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return questionContentRepository.findAll(pageable);
    }

    @Override
    public Optional<QuestionContent> findByTd(Long id) {
        return questionContentRepository.findById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void remove(Long id) {
        questionContentRepository.deleteById(id);
    }

    @Override
    public Page<QuestionContent> search(Pageable pageable, String title, String questionType) {
        return questionContentRepository.search(pageable, title, questionType);
    }
}
