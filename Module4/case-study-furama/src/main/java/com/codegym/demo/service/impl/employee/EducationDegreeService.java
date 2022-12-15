package com.codegym.demo.service.impl.employee;

import com.codegym.demo.model.employee.EducationDegree;
import com.codegym.demo.repository.employee.IEducationDegreeRepository;
import com.codegym.demo.service.inter.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
