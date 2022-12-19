package com.example.demo.service;

import java.util.List;

public interface IExtraService<T> {
    List<T> findAll();
}
