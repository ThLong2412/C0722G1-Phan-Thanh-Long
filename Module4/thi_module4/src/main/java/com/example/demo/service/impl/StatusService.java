package com.example.demo.service.impl;

import com.example.demo.model.Status;
import com.example.demo.repository.IStatusRepository;
import com.example.demo.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService {

    @Autowired
    private IStatusRepository statusRepository;
    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
