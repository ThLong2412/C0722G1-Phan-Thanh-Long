package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);
    Optional<T> findByTd(Long id);
    void save(T t);
    void remove(Long id);
    Page<T> search(Pageable pageable, String name, String questionType);
}
