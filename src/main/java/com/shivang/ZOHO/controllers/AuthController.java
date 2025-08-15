package com.shivang.ZOHO.controllers;

import com.shivang.ZOHO.DTOs.requestDTOs.loginRequest;
import com.shivang.ZOHO.DTOs.requestDTOs.signUpRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.ErrorResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.signUpResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.tokenResponse;
import com.shivang.ZOHO.security.JwtUtils;
import com.shivang.ZOHO.services.authService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@NoArgsConstructor
public class AuthController {
    private authService service;
    private AuthenticationManager manager;
    private JwtUtils utils;
    private PasswordEncoder encoder;
    @Autowired
    public AuthController(authService service, AuthenticationManager manager, JwtUtils utils, PasswordEncoder encoder){
        this.service = service;
        this.manager = manager;
        this.utils = utils;
        this.encoder = encoder;
    }
    @PostMapping("/login")
    public ResponseEntity<tokenResponse> login(@RequestBody loginRequest req){
        try{
            manager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        }
        catch (Exception e){
            System.out.println(e);
        }
        loginResponse response = service.login(req);
        String token = utils.generateToken(response);
        tokenResponse tokenResponse = new tokenResponse(response, token);
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody signUpRequest request){
        request.setPassword(encoder.encode(request.getPassword()));
        try{
            signUpResponse response = service.signup(request);
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            ErrorResponse error = new ErrorResponse(500, e.getMessage());
            return ResponseEntity.status(error.getStatus()).body(error);
        }
    }
}
