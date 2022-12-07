//package com.codegym.demo.controller;
//
//import com.codegym.demo.model.Blog;
//import com.codegym.demo.model.Category;
//import com.codegym.demo.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("category")
//public class CategoryRestController {
//    @Autowired
//    private ICategoryService categoryService;
//
//    @GetMapping("")
//    public ResponseEntity<Page<Category>> getCategory(@PageableDefault(page = 0, size = 2) Pageable pageable) {
//        Page<Category> categoryList = categoryService.findAll(pageable);
//        if (categoryList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(categoryList, HttpStatus.OK);
//    }
//
//
//}
