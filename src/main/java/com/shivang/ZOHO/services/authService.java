package com.shivang.ZOHO.services;

import com.shivang.ZOHO.DTOs.responseDTOs.signUpResponse;
import com.shivang.ZOHO.models.Users;

public interface authService {
    public Users login(String email, String password);
}
