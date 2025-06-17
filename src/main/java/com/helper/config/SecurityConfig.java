package com.helper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// import com.helper.security.CustomUserDetailsService;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    // /**
    //  * Password encoder for encoding and matching user passwords.
    // */
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // /**
    //  * In-memory users for quick testing.
    //  * Replace this with a custom UserDetailsService (e.g. MyBatis) when moving to real database users.
    // */
    // @Bean
    // public UserDetailsService userDetailsService(CustomUserDetailsService customService) {
    //     return customService;
    // }

    // /**
    //  * Exposes the AuthenticationManager for injection (e.g. in AuthController).
    //  */
    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    //     return config.getAuthenticationManager();
    // }

    // /**
    //  * Main Spring Security filter chain config.
    //  * Stateless REST API with basic auth (you can replace with JWT later).
    //  */
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http        // Disable CSRF since this is a stateless REST API
    //     .csrf(csrf -> csrf.disable())

    //     // Stateless: no session will be created or used
    //     .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

    //     // Authorization rules
    //     .authorizeHttpRequests(auth -> auth
    //         .requestMatchers("/api/public/**").permitAll()  // Public endpoints
    //         .requestMatchers("/api/admin/auth/login").permitAll() // Allow login API to be accessed without authentication
    //         .requestMatchers("/api/admin/**").hasRole("ADMIN")
    //         .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN")
    //         .anyRequest().authenticated() // Secure everything else
    //     )

    //     // Disable default login and logout pages
    //     .formLogin(form -> form.disable())
    //     .logout(logout -> logout.disable())

    //     // Use HTTP Basic authentication (you can replace this with JWT later)
    //     .httpBasic(Customizer.withDefaults());

    //     return http.build();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic();

        return http.build();
    }
}
