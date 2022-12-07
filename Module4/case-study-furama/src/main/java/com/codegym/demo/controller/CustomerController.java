package com.codegym.demo.controller;

import com.codegym.demo.dto.CustomerDto;
import com.codegym.demo.model.Customer;
import com.codegym.demo.model.CustomerType;
import com.codegym.demo.service.ICustomerService;
import com.codegym.demo.service.ICustomerTypeService;
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

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView showListCustomer(@ModelAttribute("customerDto") CustomerDto customerDto,@RequestParam( required = false, defaultValue = "") String name, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Customer> customerPage = customerService.search( pageable, name);
//        Page<Customer> customerPage = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerPage", customerPage);
        modelAndView.addObject("customerType", customerTypeService.findAll(pageable));
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
            model.addAttribute("customerType",customerTypeService.findAll(pageable));
            return "/customer/list";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        model.addAttribute("customerType",customerTypeService.findAll(pageable));
        redirectAttributes.addFlashAttribute("message", "Successfully customer added new");
        return "redirect:/customer";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Integer id, Pageable pageable) {
        Customer customer = customerService.findByTd(id).get();
        Page<CustomerType> customerTypePage = customerTypeService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            modelAndView.addObject("customerDto", customerDto);
            modelAndView.addObject("customerTypePage", customerTypePage);
            return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult  ,RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Successfully customer added new");
        return "redirect:/customer";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute("id") Integer id) {
        customerService.remove(id);
        return "redirect:/customer";
    }
}
