package com.xw.user.oauth;

import com.xw.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankh on 2017/7/26.
 */
@Configuration
@EnableAuthorizationServer
public class SpringSecurityOauth implements AuthorizationServerConfigurer {
    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordMannager passwordMannager;

    @Autowired
    AdminService adminService;

    @Autowired
    JdbcTokenStore jdbcTokenStore;

    @Bean
    public JdbcTokenStore jdbcTokenStore(){
        return new JdbcTokenStore(dataSource);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws Exception {
        authorizationServerEndpointsConfigurer.tokenStore(jdbcTokenStore);
        authorizationServerEndpointsConfigurer.authenticationManager(passwordMannager);

        List<TokenGranter> list = new ArrayList<>(1);

        TokenGranter tokenGranter = new ResourceOwnerPasswordTokenGranter(
                passwordMannager,
                authorizationServerEndpointsConfigurer.getTokenServices(),
                authorizationServerEndpointsConfigurer.getClientDetailsService(),
                authorizationServerEndpointsConfigurer.getOAuth2RequestFactory());

        list.add(tokenGranter);
        CompositeTokenGranter compositeTokenGranter = new CompositeTokenGranter(list);

        authorizationServerEndpointsConfigurer.tokenGranter(compositeTokenGranter);
    }

    @Bean
    @Primary
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(jdbcTokenStore);
        return tokenServices;
    }
}
