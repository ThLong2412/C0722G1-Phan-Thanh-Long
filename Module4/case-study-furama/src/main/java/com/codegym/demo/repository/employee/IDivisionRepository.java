package com.codegym.demo.repository.employee;

import com.codegym.demo.model.employee.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository  extends JpaRepository<Divisions, Long> {
}
