package com.example.its.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                .formLogin(login -> login.loginPage("/login"))
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
                                .anyRequest().authenticated()
                )
                ;

        return http.build();
    }
}
