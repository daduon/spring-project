package com.helper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http        // Disable CSRF since this is a stateless REST API
        .csrf(csrf -> csrf.disable())

        // Stateless: no session will be created or used
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        // Authorization rules
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/public/**").permitAll()  // Public endpoints
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated() // Secure everything else
        )

        // Disable default login and logout pages
        .formLogin(form -> form.disable())
        .logout(logout -> logout.disable())

        // Use HTTP Basic authentication (you can replace this with JWT later)
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.builder()
                            .username("admin")
                            .password(passwordEncoder().encode("1234"))
                            .roles("ADMIN")
                            .build();

        UserDetails user = User.builder()
                            .username("user")
                            .password(encoder.encode("12345"))
                            .roles("USER") // ROLE_USER
                            .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
