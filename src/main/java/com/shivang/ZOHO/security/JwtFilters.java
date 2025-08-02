package com.shivang.ZOHO.security;

import com.shivang.ZOHO.services.impl.UserService_Impl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilters extends OncePerRequestFilter {
    private JwtUtils utils;
    private UserService_Impl userService;
    private String JWT;
    @Autowired
    public JwtFilters(JwtUtils utils, UserService_Impl service){
        this.utils = utils;
        this.userService = service;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getServletPath().startsWith("/api/auth")){
            filterChain.doFilter(request, response);
            return;
        }
        String authHeader = request.getHeader("Authorization");
        JWT = authHeader.substring(7);
        String email = utils.extractUserEmail(JWT);
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userService.loadUserByUsername(email);
            if(utils.validateToken(JWT, userDetails)){
                UsernamePasswordAuthenticationToken tokenVal = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                tokenVal.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(tokenVal);
            }
        }
        else{
            System.out.println("sad");
        }
        filterChain.doFilter(request, response);
    }
}
