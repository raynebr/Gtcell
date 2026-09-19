package com.Sistema.Gtcell.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Desativa CSRF porque estamos trabalhando com uma API REST
                .csrf(csrf -> csrf.disable())

                // Define quais endpoints precisam de autenticação
                .authorizeHttpRequests(auth -> auth

                        // Por enquanto, libera todos os endpoints
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}