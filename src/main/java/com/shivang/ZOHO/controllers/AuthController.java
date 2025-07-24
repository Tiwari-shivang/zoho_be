package com.shivang.ZOHO.controllers;

import com.shivang.ZOHO.DTOs.requestDTOs.loginRequest;
import com.shivang.ZOHO.DTOs.requestDTOs.signUpRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.signUpResponse;
import com.shivang.ZOHO.services.authService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@NoArgsConstructor
public class AuthController {
    authService service;
    @Autowired
    public AuthController(authService service){
        this.service = service;
    }
    @PostMapping("/login")
    public ResponseEntity<loginResponse> login(@RequestBody loginRequest req){
        loginResponse response = service.login(req);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<signUpResponse> signup(@RequestBody signUpRequest request){
        signUpResponse response = service.signup(request);
        return ResponseEntity.ok(response);
    }
}
