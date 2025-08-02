package com.shivang.ZOHO.config;

import com.shivang.ZOHO.security.JwtFilters;
import com.shivang.ZOHO.services.impl.UserService_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserService_Impl userService;
    @Autowired
    private JwtFilters jwtFilters;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(request -> request.requestMatchers("/api/auth/login").permitAll().anyRequest().authenticated()).csrf(AbstractHttpConfigurer::disable).userDetailsService(userService).addFilterBefore(jwtFilters, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public PasswordEncoder encoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager manager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
