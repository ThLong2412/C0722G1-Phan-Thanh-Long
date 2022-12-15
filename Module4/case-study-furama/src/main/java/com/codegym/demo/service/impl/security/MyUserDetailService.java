package com.codegym.demo.service.impl.security;

import com.codegym.demo.model.security.MyUserDetail;
import com.codegym.demo.model.security.User;
import com.codegym.demo.repository.security.IUserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Bước 4: Tạo service
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IUserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }

        return new MyUserDetail(user);
    }
}
