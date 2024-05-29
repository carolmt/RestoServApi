package com.example.restoservapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/******************************************************
 * Esta clase es usada para iniciar la aplicación.
 ******************************************************/
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class,
UserDetailsServiceAutoConfiguration.class})
public class RestoServApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestoServApiApplication.class, args);
    }

}

