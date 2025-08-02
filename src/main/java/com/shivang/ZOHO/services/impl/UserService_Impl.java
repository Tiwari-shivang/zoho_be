package com.shivang.ZOHO.services.impl;

import com.shivang.ZOHO.models.CustomUserDetails;
import com.shivang.ZOHO.models.Users;
import com.shivang.ZOHO.repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService_Impl implements UserDetailsService {
    AuthRepo authRepo;
    @Autowired
    public UserService_Impl(AuthRepo authRepo){
        this.authRepo = authRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = authRepo.findByEmail(username);
        return new CustomUserDetails(user);
    }
}
