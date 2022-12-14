package com.codegym.demo.model.employee;

import com.codegym.demo.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Divisions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "divisions")
    private Set<Employee> employees;

    public Divisions() {
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employee) {
        this.employees = employee;
    }
}