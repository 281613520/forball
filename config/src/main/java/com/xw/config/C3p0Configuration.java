package com.xw.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by AnKh on 2017/5/26.
 */
@Configuration
public class C3p0Configuration {
    @Value("${config.c3p0.max_size}")
    private int maxSize;

    @Value("${config.c3p0.min_size}")
    private int minSize;

    @Value("${config.c3p0.init_size}")
    private int initSize;

    @Value("${config.c3p0.acquire_increment}")
    private int acquireIncrement;

    @Value("${config.c3p0.idle_test_period}")
    private int idleTestPeriod;

    @Value("${config.c3p0.max_statements}")
    private int maxStatements;

    @Value("${config.c3p0.max_idle_time}")
    private int maxIdleTime;

    @Value("${config.c3p0.url}")
    private String url;

    @Value("${config.c3p0.username}")
    private String username;

    @Value("${config.c3p0.password}")
    private String password;

    @Value("${config.c3p0.driverClassName}")
    private String driverClassName;

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setMaxPoolSize(maxSize);
        dataSource.setMinPoolSize(minSize);
        dataSource.setInitialPoolSize(initSize);

        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setIdleConnectionTestPeriod(idleTestPeriod);
        dataSource.setMaxStatements(maxStatements);
        dataSource.setMaxIdleTime(maxIdleTime);
        dataSource.setJdbcUrl(url);
        dataSource.setPassword(password);
        dataSource.setUser(username);
        dataSource.setDriverClass(driverClassName);
        return dataSource;
    }

}
