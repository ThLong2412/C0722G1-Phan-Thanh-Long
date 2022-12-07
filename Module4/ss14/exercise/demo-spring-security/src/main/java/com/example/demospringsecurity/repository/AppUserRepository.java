package com.example.demospringsecurity.repository;

import com.example.demospringsecurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName (String userName);
}
