package com.codegym.demo.service.impl;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll() ;
    }

    @Override
    public Optional<Blog> findByTd(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> search(String name) {
        return blogRepository.findByNameIsContaining(name);
    }
}
