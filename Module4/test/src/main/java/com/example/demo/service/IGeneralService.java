package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();
    Optional<T> findByTd(Long id);
    void save(T t);
    void remove(String id);
    Page<T> search(Pageable pageable, String name);
}
