package com.acn.bootcamp.simpleshop.configurations;

import com.acn.bootcamp.simpleshop.Constants;
import com.acn.bootcamp.simpleshop.configurations.jwt.JwtAuthenticationFilter;
import com.acn.bootcamp.simpleshop.data.enums.Role;
import com.acn.bootcamp.simpleshop.services.UserIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.EnumSet;

@Configuration
@EnableMethodSecurity
public class ApiSecurityConfiguration  {


    private final JwtAuthenticationFilter authenticationFilter;
    private final UserIdentityService identityService;

    @Autowired
    public ApiSecurityConfiguration(JwtAuthenticationFilter authenticationFilter, UserIdentityService identityService) {
        this.authenticationFilter = authenticationFilter;
        this.identityService = identityService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        var authorities = EnumSet.allOf(Role.class).stream()
                .map(item -> item.name())
                .toArray(String[]::new);
        http
                //.cors(cors -> cors.configurationSource(getCorsConfigSource()))
                .headers(opt -> opt.frameOptions(frame -> frame.disable()))
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorization ->
                        authorization
                                .requestMatchers(new AntPathRequestMatcher(Constants.H2_CONSOLE + "/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/docs/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/swagger/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher(Constants.AUTH_ENDPOINT + "/**")).permitAll()
                                .anyRequest()
                                .authenticated())
                .sessionManagement(options -> options.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .userDetailsService(identityService);
        return http.build();
    }


}
