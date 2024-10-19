package com.bookIt.demo.tool.jwtToken;

import com.bookIt.demo.model.Customer;
import com.bookIt.demo.model.UserAccount;
import com.bookIt.demo.model.Worker;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenTool {

    // todo implement file
    private final String secretKey = "9294829482E7FJEDJENZDZDZJAcczdzZDJbcecej0099913ZZZZZZZZTTYYYSCXWXWXXWXWXWXZJDZBDZDZDZDDZDZDZDZDZDZefefeefefefefefvcvvbnncaawwxxDZDZZDB92BNCSJKNCSZSZDZDDZ";

    public String generateToken(UserAccount userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userAccountId", userDetails.getId());
        return doGenerateToken(claims, userDetails.getEmail());
    }

    public String generateToken(Customer customer) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("customerId", customer.getId());
        return doGenerateToken(claims, customer.getUser().getEmail());
    }

    public String generateToken(Worker worker) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("workerId", worker.getId());
        return doGenerateToken(claims, worker.getUser().getEmail());
    }


    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        if (claims == null) {
            return null;
        }
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        if (username == null) {
            return false;
        }
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = extractClaim(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Boolean validateToken(String token, Customer customer) {
        final String username = extractUsername(token);
        if (username == null) {
            return false;
        }
        return (username.equals(customer.getUser().getEmail()) && !isTokenExpired(token));
    }

    public Boolean validateToken(String token, Worker worker) {
        final String username = extractUsername(token);
        if (username == null) {
            return false;
        }
        return (username.equals(worker.getUser().getEmail()) && !isTokenExpired(token));
    }


}
