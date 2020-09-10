package com.infoplusvn.ctm.security.api;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.infoplusvn.ctm.security.SecurityConstants.EXPIRATION_TIME;
import static com.infoplusvn.ctm.security.SecurityConstants.SECRET;

/**
 * Created by https://github.com/kwanpham
 */
public class TokenProvider {

    public static String generateToken(Authentication auth) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        String login = user.getUsername();
        if (login != null && login.length() > 0) {
            Claims claims = Jwts.claims().setSubject(login);
            List<String> roles = new ArrayList<>();
            user.getAuthorities().forEach(authority -> roles.add(authority.getAuthority()));
            claims.put("roles", roles);
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
            return token;
        }
        return null;
    }

}
