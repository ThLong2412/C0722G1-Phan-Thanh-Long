package com.example.demo.service.impl;

import com.example.demo.model.Phim;
import com.example.demo.repository.IPhimRepository;
import com.example.demo.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhimService implements IPhimService {
    @Autowired
    private IPhimRepository phimRepository;
    @Override
    public List<Phim> findAll() {
        return phimRepository.findAll();
    }

    @Override
    public Optional<Phim> findByTd(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Phim phim) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public Page<Phim> search(Pageable pageable, String name) {
        return null;
    }
}
