package com.codegym.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IExtraService<T> {
    Page<T> findAll(Pageable pageable);
}
