package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.IBlogService;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blogs")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;


    @GetMapping("")
    public ResponseEntity<Page<Blog>> getListBlog(@PageableDefault(page = 0, size = 2) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Blog>> getBlog(@PathVariable("id") Long id) {
        Optional<Blog> blogOptional = blogService.findByTd(id);
        return new ResponseEntity<>(blogOptional, HttpStatus.OK);
    }

    @GetMapping("search/{id}")
    public ResponseEntity<List<Blog>> search(@PathVariable("id") Long id, @PageableDefault(page = 0, size = 2) Pageable pageable){
        List<Blog> blogList = blogService.search(id, pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
