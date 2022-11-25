package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findByTd(Long id);
    void save(T t);
    void remove(Long id);
    List<Blog> search(String name);
}
