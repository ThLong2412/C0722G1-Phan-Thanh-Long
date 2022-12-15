package com.codegym.demo.repository.security;

import com.codegym.demo.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDetailRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

