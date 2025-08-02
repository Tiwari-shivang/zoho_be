package com.shivang.ZOHO.controllers;
import com.shivang.ZOHO.DTOs.requestDTOs.loginRequest;
import com.shivang.ZOHO.DTOs.requestDTOs.signUpRequest;
import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import com.shivang.ZOHO.DTOs.responseDTOs.signUpResponse;
import com.shivang.ZOHO.security.JwtUtils;
import com.shivang.ZOHO.services.authService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    @Autowired
    public AuthController(authService service, AuthenticationManager manager, JwtUtils utils){
        this.service = service;
        this.manager = manager;
        this.utils = utils;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody loginRequest req) throws Exception{
        try{
            manager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        }
        catch (Exception e){
            System.out.println(e);
        }
        loginResponse response = service.login(req);
        String token = utils.buildJWT(response);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<signUpResponse> signup(@RequestBody signUpRequest request){
        signUpResponse response = service.signup(request);
        return ResponseEntity.ok(response);
    }
}
