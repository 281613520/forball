package com.xw.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by AnKh on 2017/5/24.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.xw.*" })
@EntityScan(basePackages = {"com.xw.*"})
@EnableJpaRepositories(basePackages = { "com.xw.*" })
public class Boot {
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
