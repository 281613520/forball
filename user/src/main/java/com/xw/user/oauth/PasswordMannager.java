package com.xw.user.oauth;

import com.xw.commons.exception.ParamErrorException;
import com.xw.user.entity.Admin;
import com.xw.user.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankh on 2017/7/29.
 */
@Slf4j
@Component
public class PasswordMannager implements AuthenticationManager{

    @Autowired
    AdminService adminService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        //todo if null
        if (userName.isEmpty() || password.isEmpty()){
            throw new ParamErrorException("null");
        }

        Admin adminFormDB = adminService.findByUserName(userName);

        if (adminFormDB == null){
            throw new ParamErrorException("111");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));

        return new UsernamePasswordAuthenticationToken(userName,password,authorities);

    }
}
