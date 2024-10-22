package com.mark.autostock.config;

import com.mark.autostock.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfigurator {
    public SecurityConfigurator() {}
    private TokenFilter tokenFilter;
    @Autowired
    public void setTokenFilter(TokenFilter tokenFilter) {
        this.tokenFilter = tokenFilter;
    }
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    @Primary
    public AuthenticationManagerBuilder configureAuthenticationManagerBuilder(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer.configurationSource(request -> {
                            CorsConfiguration configuration = new CorsConfiguration();
                            configuration.setAllowedOrigins(Arrays.asList(
                                    "http://localhost:5173", "http://localhost:8080"));
                            configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE", "PATCH"));
                            configuration.setAllowCredentials(true);
                            configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
                            return configuration;
                        })
                )

                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                // TODO донастроить защищенный роутинг
                .authorizeHttpRequests(authorize -> authorize
                        // Эндпоинты без аутентификации
                        .requestMatchers("/api/v1/auth/signin", "/api/v1/auth/signup").permitAll()

                        .requestMatchers("/api/v1/auth/role/**", "/api/v1/auth/refresh_token", "/api/v1/user/**").hasAuthority("ADMIN") // Добавили правила для этих маршрутов

                        // Эндпоинты для CLIENT
                        .requestMatchers("/api/v1/preorder/add", "/api/v1/testdrive/add").hasAnyAuthority("CLIENT", "ADMIN", "EMPLOYER")

                        // Эндпоинт для GUEST (только просмотр всех автомобилей)
                        .requestMatchers("/api/v1/auto/getAll").hasAnyAuthority("CLIENT", "GUEST", "ADMIN", "EMPLOYER")

                        // Эндпоинты для EMPLOYER
                        .requestMatchers("/api/v1/auto/**", "/api/v1/client/**", "/api/v1/sell/**",
                                "/api/v1/payment/**", "/api/v1/equipment/**", "/api/v1/equipmentRel/**",
                                "/api/v1/testdrive/**", "/api/v1/preorder/**").hasAnyAuthority("EMPLOYER", "ADMIN")

                        // Все остальные запросы требуют аутентификации
                        .anyRequest().authenticated()
                )

                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
