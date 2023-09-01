package com.acn.bootcamp.simpleshop.configurations.jwt;

import com.acn.bootcamp.simpleshop.Constants;
import com.acn.bootcamp.simpleshop.services.JwtService;
import com.acn.bootcamp.simpleshop.services.UserIdentityService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Log4j2
@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private final JwtService service;
    private final UserIdentityService identityService;
    private final JwtConfiguration configuration;


    @Autowired
    public JwtAuthenticationFilter(JwtService service, UserIdentityService identityService, JwtConfiguration configuration) {
        this.service = service;
        this.identityService = identityService;
        this.configuration = configuration;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (request.getServletPath().contains(Constants.AUTH_ENDPOINT)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith(configuration.getPrefix())) {
            filterChain.doFilter(request, response);
            return;
        }

        final String token = header.replace(configuration.getPrefix(), "").trim();

        final String username = service.validateTokenAndGetUsername(token);
        if (username == null) {
            // validation failed or token expired
            filterChain.doFilter(request, response);
            return;
        }

        // set user details on spring security context
        final UserDetails userDetails = identityService.loadUserByUsername(username);
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // continue with authenticated user
        filterChain.doFilter(request, response);
    }
}
