package com.codegym.demo.controller;

import com.codegym.demo.model.employee.Divisions;
import com.codegym.demo.model.employee.EducationDegree;
import com.codegym.demo.model.employee.Employee;
import com.codegym.demo.model.employee.Position;
import com.codegym.demo.service.inter.employee.IDivisionService;
import com.codegym.demo.service.inter.employee.IEducationDegreeService;
import com.codegym.demo.service.inter.employee.IEmployeeService;
import com.codegym.demo.service.inter.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IPositionService positionService;
    @GetMapping("")
    public String getHome(@RequestParam(required = false, defaultValue = "") String name, @PageableDefault(page = 0, size = 5) Pageable pageable, Model model) {
        Page<Employee> employeePage = employeeService.findAllEmployee(pageable, name);
        List<Divisions> divisionsList = divisionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Position> positionList = positionService.findAll();
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("divisionsList", divisionsList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("positionList", positionList);
        return "/employee/list";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Long id) {
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
