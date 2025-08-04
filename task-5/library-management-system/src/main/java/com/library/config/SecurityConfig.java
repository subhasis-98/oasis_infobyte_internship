// SecurityConfig.java placeholder
package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/books", "/api/transactions/**", "/api/email/**", "/").permitAll()
                        .requestMatchers("/api/books/**", "/api/members/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf().disable()
                .formLogin().disable();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.withUsername("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .build());
        userDetailsService.createUser(User.withUsername("user")
                .password("{noop}user123")
                .roles("USER")
                .build());
        return userDetailsService;
    }
}