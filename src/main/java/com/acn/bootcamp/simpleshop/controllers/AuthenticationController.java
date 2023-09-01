package com.acn.bootcamp.simpleshop.controllers;

import com.acn.bootcamp.simpleshop.Constants;
import com.acn.bootcamp.simpleshop.data.dto.response.AuthenticationResponse;
import com.acn.bootcamp.simpleshop.data.dto.UserCredential;
import com.acn.bootcamp.simpleshop.data.dto.response.ErrorResponse;
import com.acn.bootcamp.simpleshop.data.enums.ErrorCode;
import com.acn.bootcamp.simpleshop.services.JwtService;
import com.acn.bootcamp.simpleshop.services.UserIdentityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping( path = Constants.AUTH_ENDPOINT, produces = "application/json")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserIdentityService identityService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtService jwtService, UserIdentityService identityService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.identityService = identityService;
    }

    @PostMapping("/")
    public ResponseEntity authenticate(@RequestBody UserCredential credential) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credential.getUsername(), credential.getPassword()));
            final var userDetails = identityService.loadUserByUsername(credential.getUsername());
            final var payload = new AuthenticationResponse(jwtService.generateToken(userDetails));

            return ResponseEntity.ok(payload);
        } catch (final Exception e)
        {
            log.warn("Caught %s while authenticating credential".formatted(e.getMessage()));
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse(ErrorCode.INVALID_CREDENTIALS, e.getMessage()));
        }
    }


}
