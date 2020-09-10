package com.infoplusvn.ctm.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by https://github.com/kwanpham
 */
public class SecurityUtil {

    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        return results;
    }

    public static User getPrincipal() {
        User  myUserDetail = (User ) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return myUserDetail;
    }
}
