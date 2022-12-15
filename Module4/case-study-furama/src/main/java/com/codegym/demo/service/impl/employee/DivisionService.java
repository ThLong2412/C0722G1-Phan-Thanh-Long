package com.codegym.demo.service.impl.employee;

import com.codegym.demo.model.employee.Divisions;
import com.codegym.demo.repository.employee.IDivisionRepository;
import com.codegym.demo.service.inter.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Divisions> findAll() {
        return divisionRepository.findAll();
    }
}
