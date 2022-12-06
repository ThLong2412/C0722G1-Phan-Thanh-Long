package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface IBlogRepository  extends JpaRepository<Blog, Long> {

    List<Blog> findByCategory_Id(Long id);
    Page<Blog> findByNameIsContaining(String name, Pageable pageable);
}
