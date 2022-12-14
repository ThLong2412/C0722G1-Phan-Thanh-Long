package com.codegym.demo.controller;

import com.codegym.demo.dto.CustomerDto;
import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.customer.CustomerType;
import com.codegym.demo.service.inter.customer.ICustomerService;
import com.codegym.demo.service.inter.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView showListCustomer(@ModelAttribute("customerDto") CustomerDto customerDto,@RequestParam( required = false, defaultValue = "") String name, @RequestParam( required = false, defaultValue = "") String email,@RequestParam( required = false, defaultValue = "") String customerTypeId,@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Customer> customerPage = customerService.search( pageable, name, email, customerTypeId);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerPage", customerPage);
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult , Model model, RedirectAttributes redirectAttributes, Pageable pageable){
        new CustomerDto().validate(customerDto, bindingResult);
        Page<Customer> customerPage;
        if (bindingResult.hasErrors()) {
            model.addAttribute("mess", 1);
            customerPage = customerService.findAll(pageable);
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        redirectAttributes.addFlashAttribute("message", "Successfully customer added new");
        return "redirect:/customer";
    }


    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult  ,RedirectAttributes redirectAttributes, Model model, Pageable pageable){
        new CustomerDto().validate(customerDto, bindingResult);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        Page<Customer> customerPage;
        if (bindingResult.hasErrors()) {
            customerPage = customerService.findAll(pageable);
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("customerTypeList",customerTypeService.findAll());
            model.addAttribute("messUpdate", 1);
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Successfully customer added new");
        return "redirect:/customer";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Long id) {
        customerService.remove(id);
        return "redirect:/customer";
    }
}
