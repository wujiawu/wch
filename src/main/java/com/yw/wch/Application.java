package com.yw.wch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by wujiawu on 2017/5/4.
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@EntityScan(basePackageClasses = Application.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
