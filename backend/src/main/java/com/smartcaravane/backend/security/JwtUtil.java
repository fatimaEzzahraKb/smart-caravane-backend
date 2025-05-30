package com.smartcaravane.backend.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private String SECRET_KEY = "your_secret_key";

    public String extractUsername(String token) { /*...*/
        return token;
    }
    public Date extractExpiration(String token) { /*...*/
        return null;
    }
    private Claims extractAllClaims(String token) { /*...*/
        return null;
    }
    private Boolean isTokenExpired(String token) { /*...*/
        return null;
    }
    public String generateToken(UserDetails userDetails) { /*...*/
        return "";
    }
    public Boolean validateToken(String token, UserDetails userDetails) { /*...*/
        return null;
    }
}
