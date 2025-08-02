package com.shivang.ZOHO.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shivang.ZOHO.DTOs.responseDTOs.loginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    private final String SECRET = "yourSuperSecretKey_ThatIsLongEnoughForHS256";
    private final Key secreat_key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    public String buildJWT(loginResponse responseObj) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("id", responseObj.getId().toString());
        map.put("first_name", responseObj.getFirst_name());
        map.put("last_name", responseObj.getLast_name());
        map.put("role_name", responseObj.getRole_name());
        map.put("email", responseObj.getEmail());
        map.put("is_active", String.valueOf(responseObj.is_active()));
        map.put("created_at", String.valueOf(responseObj.getCreated_at()));
        map.put("updated_at", String.valueOf(responseObj.getUpdate_at()));
        String token = Jwts.builder().signWith(secreat_key).setSubject(responseObj.getEmail()).claim("user", map).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).compact();
        return token;
    }

    public Boolean validateToken(String token, UserDetails user){
        String email = extractUserEmail(token);
        return email.matches(user.getUsername()) && !isTokenExpired(token);
    }

    public String extractUserEmail(String token){
        String email = Jwts.parserBuilder().setSigningKey(secreat_key).build().parseClaimsJws(token).getBody().getSubject();
        return email;
    }

    public Boolean isTokenExpired(String token){
        Date exp = Jwts.parserBuilder().setSigningKey(secreat_key).build().parseClaimsJws(token).getBody().getExpiration();
        return exp.before(new Date());
    }
}
