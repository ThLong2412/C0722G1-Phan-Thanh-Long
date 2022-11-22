package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String showList(Model model) {
//        ModelAndView modelAndView = new ModelAndView("/customers/list");
        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
        model.addAttribute("customers", customers);
        return "/customers/list";
    }

    @GetMapping("/{id}")
    public String showInformation(@PathVariable Long id, Model model) {
//        ModelAndView modelAndView = new ModelAndView("/customers/info");
        Customer customer = customerService.findOne(id);
//        modelAndView.addObject("customer", customer);
        model.addAttribute("customer",customer);
        model.addAttribute("id", id);
        return "/customers/info";
    }

    @GetMapping("/update")
    public String updateCustomer(Customer customer) {
       customerService.save(customer);
        return "redirect:/customers/list";
    }

}

