//package com.codegym.demo.controller;
//
//import com.codegym.demo.model.Category;
//import com.codegym.demo.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/category")
//public class CategoryController {
//    @Autowired
//    private ICategoryService categoryService;
//    @GetMapping("")
//    public ModelAndView showListBlog(@RequestParam(required = false,value = "") String name, @PageableDefault(page = 0, size = 5) Pageable pageable) {
//
//        Page<Category> categoryPage = categoryService.search( pageable, name);
//        ModelAndView modelAndView = new ModelAndView("/category/list");
//        modelAndView.addObject("categoryPage", categoryPage);
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showFormCreate() {
//    ModelAndView modelAndView = new ModelAndView("/category/create");
//    modelAndView.addObject("category", new Category());
//    return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView create(@ModelAttribute ("category") Category category) {
//        categoryService.save(category);
//        ModelAndView modelAndView = new ModelAndView("/category/create");
//        modelAndView.addObject("category", new Category());
//        modelAndView.addObject("message", "New category created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showFormEdit(@PathVariable Long id) {
//        Optional<Category> category = categoryService.findByTd(id);
//        if (category.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/category/edit");
//            modelAndView.addObject("category", category.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView update(@ModelAttribute("category") Category category ) {
//        categoryService.save(category);
//        ModelAndView modelAndView = new ModelAndView("/category/edit");
//        modelAndView.addObject("category", category);
//        modelAndView.addObject("message", "Category updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/view/{id}")
//    public ModelAndView showView(@PathVariable Long id) {
//        Optional<Category> category = categoryService.findByTd(id);
//        ModelAndView modelAndView = new ModelAndView("/category/view");
//        modelAndView.addObject("category", category.get());
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showFormDelete(@PathVariable Long id) {
//        Optional<Category> category = categoryService.findByTd(id);
//        if (category.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/category/delete");
//            modelAndView.addObject("category", category.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteBlog(@ModelAttribute("category") Category category) {
//        categoryService.remove(category.getId());
//        return "redirect:/category";
//    }
//}
