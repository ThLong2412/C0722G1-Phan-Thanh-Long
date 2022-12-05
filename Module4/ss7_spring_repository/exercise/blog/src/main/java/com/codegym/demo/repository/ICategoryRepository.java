package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import com.codegym.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
//    List<Category> findByBlogsContaining(String name);
}
