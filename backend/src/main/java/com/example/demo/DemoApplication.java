package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }


    @Configuration
    public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http .csrf().disable() .authorizeRequests() .anyRequest().permitAll();
//            http
//                    .authorizeRequests(authz -> authz
//                            .antMatchers(HttpMethod.GET, "/user/**").hasAuthority("SCOPE_read")
//                            .antMatchers(HttpMethod.POST, "/user/registration").hasAuthority("SCOPE_write")
//                            .anyRequest().authenticated())
//                    .oauth2ResourceServer(oauth2 -> oauth2.jwt());
//
        }

    }

}
//"D:\programs\mysql-8.0.19-winx64\bin\mysqld" --console