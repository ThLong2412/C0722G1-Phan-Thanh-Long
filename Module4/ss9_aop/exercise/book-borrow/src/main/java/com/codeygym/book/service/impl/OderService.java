package com.codeygym.book.service.impl;

import com.codeygym.book.model.Oder;
import com.codeygym.book.repository.IOderRepository;
import com.codeygym.book.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository oderRepository;

    @Override
    public Page<Oder> findAll(Pageable pageable) {
        return oderRepository.findAll(pageable);
    }

    @Override
    public Optional<Oder> findByTd(Long id) {
        return oderRepository.findById(id);
    }

    @Override
    public void update(Oder oder) {
        oderRepository.save(oder);
    }

    @Override
    public void remove(Long id) {
        oderRepository.deleteById(id);
    }
}
