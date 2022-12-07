package com.example.demospringsecurity.repository;

import com.example.demospringsecurity.model.AppUser;
import com.example.demospringsecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);
}
