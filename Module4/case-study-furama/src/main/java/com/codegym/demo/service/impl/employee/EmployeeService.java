package com.codegym.demo.service.impl.employee;

import com.codegym.demo.model.employee.Employee;
import com.codegym.demo.repository.employee.IEmployeeRepository;
import com.codegym.demo.service.inter.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findByTd(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.removeFlag(id);
    }

    @Override
    public Page<Employee> search(Pageable pageable, String name, String email, String customerType) {
        return null;
    }

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, String name) {
        return employeeRepository.findEmployee(pageable, name);
    }
}
