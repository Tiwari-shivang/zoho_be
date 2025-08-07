package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.models.UserService;
import com.shivang.ZOHO.models.Users;
import com.shivang.ZOHO.repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService_Impl implements UserDetailsService {

    private final AuthRepo repo;

    @Autowired
    public UserService_Impl(AuthRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByEmail(username);
        return new UserService(user);
    }
}
