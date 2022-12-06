package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.ICustomerService;
import com.codegym.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView showListCustomer(@ModelAttribute("customer") Customer customer,@RequestParam( required = false, defaultValue = "") String name, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Customer> customerPage = customerService.search( pageable, name);
//        Page<Customer> customerPage = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerPage", customerPage);
        modelAndView.addObject("customerType", customerTypeService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer")Customer customer ,Model model, RedirectAttributes redirectAttributes, Pageable pageable){
        customerService.save(customer);
        model.addAttribute("mess", 1);
        model.addAttribute("customerType",customerTypeService.findAll(pageable));
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/customer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("id") Integer id ,RedirectAttributes redirectAttributes, Model model, Pageable pageable){
        Optional<Customer> customer = customerService.findByTd(id);
        customerService.save(customer.get());
        model.addAttribute("mess", 1);
        model.addAttribute("customerType",customerTypeService.findAll(pageable));
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
        return "redirect:/customer";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Integer id) {
        customerService.remove(id);
        return "redirect:/customer";
    }
}
