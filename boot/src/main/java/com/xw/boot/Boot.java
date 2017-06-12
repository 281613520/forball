package com.xw.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by AnKh on 2017/5/24.
 */
@SpringBootApplication(scanBasePackages = {"com.xw.*"})
@EntityScan(basePackages = {"com.xw.*"})
public class Boot {
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
