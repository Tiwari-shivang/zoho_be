package com.shivang.ZOHO.services;

import com.shivang.ZOHO.DTOs.requestDTOs.loginRequest;
import com.shivang.ZOHO.DTOs.requestDTOs.signUpRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.signUpResponse;
import com.shivang.ZOHO.models.Users;

public interface authService {
    loginResponse login(loginRequest request);
    signUpResponse signup(signUpRequest request);
}
