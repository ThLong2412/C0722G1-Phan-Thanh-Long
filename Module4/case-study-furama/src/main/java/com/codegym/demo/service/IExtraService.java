package com.codegym.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExtraService<T> {
    List<T> findAll();
}
