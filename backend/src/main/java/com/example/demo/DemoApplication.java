package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

//    @Configuration
//    public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests(authz -> authz
//                            .antMatchers(HttpMethod.GET, "/user/**").hasAuthority("SCOPE_read")
//                            .antMatchers(HttpMethod.POST, "/user/registration").hasAuthority("SCOPE_write")
//                            .anyRequest().authenticated())
//                    .oauth2ResourceServer(oauth2 -> oauth2.jwt());
//        }
//    }

}
//"D:\programs\mysql-8.0.19-winx64\bin\mysqld" --console