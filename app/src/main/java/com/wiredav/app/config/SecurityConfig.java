package com.wiredav.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/api/v1/consultations/**").permitAll();
//                    auth.anyRequest().authenticated();
                    auth.anyRequest().permitAll();
                })
                .build();
    }
}
