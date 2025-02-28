package com.infoplusvn.ctm.security.api;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.infoplusvn.ctm.security.SecurityConstants.*;

/**
 * Created by https://github.com/kwanpham
 */
public class ApiJWTAuthorizationFilter extends BasicAuthenticationFilter {
    public ApiJWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication;
        try {
          authentication = getAuthentication(req);
        } catch (Exception e) {
            chain.doFilter(req, res);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            // Extract the UserName
            String user = claims.getSubject();
            // Extract the Roles
            ArrayList<String> roles = (ArrayList<String>) claims.get("roles");
            // Then convert Roles to GrantedAuthority Object for injecting
            ArrayList<GrantedAuthority> list = new ArrayList<>();
            if (roles != null) {
                for (String a : roles) {
                    GrantedAuthority g = new SimpleGrantedAuthority(a);
                    list.add(g);
                }
            }
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, list);
            }
            return null;
        }
        return null;
    }

    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        try {
            response.getWriter().write("Wrong username or password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
