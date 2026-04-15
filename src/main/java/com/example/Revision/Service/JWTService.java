package com.example.Revision.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService {

    private static final String SECRET_KEY = "pedido-cliente-secreta-super-program-1234567890";

    public Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).
                setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1hr
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    public String validateToken(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody().getSubject();
    }
}
