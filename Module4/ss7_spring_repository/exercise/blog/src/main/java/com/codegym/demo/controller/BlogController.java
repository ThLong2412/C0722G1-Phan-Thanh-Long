//package com.codegym.demo.controller;
//
//import com.codegym.demo.model.Blog;
//import com.codegym.demo.model.Category;
//import com.codegym.demo.service.IBlogService;
//import com.codegym.demo.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.jws.WebParam;
//import java.util.Optional;
//
//@Controller
////@RequestMapping("/blog")
//public class BlogController {
//    @Autowired
//    private IBlogService blogService;
//    @Autowired
//    private ICategoryService categoryService;
//    @GetMapping("/blog")
//    public ModelAndView showListBlog(@RequestParam(required = false,value = "") String name, @PageableDefault(page = 0, size = 5) Pageable pageable) {
////        Iterable<Blog> blogs = blogService.findAll(pageable);
//        Page<Blog> blogs = blogService.search( pageable, name);
////        Page<Category> categoryPage = categoryService.search(pageable, name);
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogs", blogs);
//        return modelAndView;
//    }
//
//    @GetMapping("/create")
//    public ModelAndView showCreate(Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("/blog/create");
//        modelAndView.addObject("blog", new Blog());
//        Page<Category> categoryPage = categoryService.findAll(pageable);
//        modelAndView.addObject("categoryPage", categoryPage);
//        modelAndView.addObject("message", "Blog create successfully");
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public ModelAndView save(Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/blog/create");
//        return modelAndView;
//    }
//    @GetMapping("/edit/{id}")
//    public ModelAndView showFormEdit(@PathVariable Long id, Pageable pageable) {
//        Optional<Blog> blog = blogService.findByTd(id);
//        Page<Category> categoryPage = categoryService.findAll(pageable);
//        if (blog.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/blog/edit");
//            modelAndView.addObject("blog", blog.get());
//            modelAndView.addObject("categoryPage", categoryPage);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit")
//    public ModelAndView update(@ModelAttribute("blog") Blog blog) {
//        blogService.save(blog);
//        ModelAndView modelAndView = new ModelAndView("/blog/edit");
//        modelAndView.addObject("blog", blog);
//        modelAndView.addObject("message", "Blog updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/view/{id}")
//    public ModelAndView showView(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findByTd(id);
//        ModelAndView modelAndView = new ModelAndView("/blog/view");
//        modelAndView.addObject("blog", blog.get());
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showFormDelete(@PathVariable Long id) {
//        Optional<Blog> blog = blogService.findByTd(id);
//        if (blog.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/blog/delete");
//            modelAndView.addObject("blog", blog.get());
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
//        blogService.remove(blog.getId());
//        return "redirect:/blog";
//    }
//}
