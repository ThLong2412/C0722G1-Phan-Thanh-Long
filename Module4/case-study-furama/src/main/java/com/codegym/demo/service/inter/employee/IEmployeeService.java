package com.codegym.demo.service.inter.employee;

import com.codegym.demo.model.employee.Employee;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAllEmployee(Pageable pageable, String name);
}
