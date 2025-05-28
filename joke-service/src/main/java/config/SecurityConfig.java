package config;

import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/random").permitAll()  // Explicit tillåt
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        String secret = "hemligtvärde1234567890hemligt1234";
        return NimbusJwtDecoder.withSecretKey(Keys.hmacShaKeyFor(secret.getBytes())).build();
    }

}