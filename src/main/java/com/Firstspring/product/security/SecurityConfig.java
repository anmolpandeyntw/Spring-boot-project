package com.Firstspring.product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Firstspring.product.service.KeyCloakRoleReader;

import org.springframework.core.convert.converter.Converter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtRequestFilter requestFilter;

    @Bean // This annotation is crucial for Spring to use this security configuration
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF for easier API testing
                .authorizeHttpRequests(request -> {
                    // Public endpoints — accessible without authentication
                    request.requestMatchers("/user/register", "/user/login").permitAll();

                    // Allow GET requests under /api/** without authentication
                    request.requestMatchers(HttpMethod.GET, "/**").permitAll();

                    // Any other request (like PUT, DELETE to categories, or any request outside /api/) requires authentication
                    request.anyRequest().authenticated();
                })

                // Enable JWT authentication for OAuth2 Resource Server (Keycloak)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(
                        jwtSpec -> jwtSpec.jwtAuthenticationConverter(jwtAuthenticationConverter())
                ))

                // Stateless session because JWT doesn’t require server session storage
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
//                .httpBasic(Customizer.withDefaults()); // Enable HTTP Basic authentication for authenticated requests

        return http.build();
    }

    // Custom converter to extract roles from Keycloak JWT tokens
    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleReader());
        return jwtAuthenticationConverter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean   // it is for the basic auth
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails seller = User.builder()
//                .username("seller")
//                .password(passwordEncoder().encode("seller"))
//                .roles("SELLER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, seller);
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
}
