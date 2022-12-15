package com.codegym.demo.service.impl.employee;

import com.codegym.demo.model.employee.Position;
import com.codegym.demo.repository.employee.IPositionRepository;
import com.codegym.demo.service.inter.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
