package com.shivang.ZOHO.security;

import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtils {
    private final String mySecretStringVal = "This_is_my_secret_key-long_enough";
    private final Key secretKey = Keys.hmacShaKeyFor(mySecretStringVal.getBytes(StandardCharsets.UTF_8));
    public String generateToken(loginResponse user){
        Map<String, String> claims = new HashMap<>();
        claims.put("id", user.getId().toString());
        claims.put("first_name", user.getFirst_name());
        claims.put("last_name", user.getLast_name());
        claims.put("role_name", user.getRole_name());
        claims.put("email", user.getEmail());
        claims.put("is_active", String.valueOf(user.is_active()));
        return Jwts.builder().signWith(secretKey).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).setSubject(user.getEmail()).claim("user", claims).compact();
    }

    public Boolean validateToken(String token, UserDetails user){
        return user.getUsername().matches(extractSubject(token));
    }

    public String extractSubject(String token){
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }
}
