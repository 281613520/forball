package com.xw.user.oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by Ankh on 2017/7/25.
 */
@Slf4j
@Configuration
@EnableAuthorizationServer
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
