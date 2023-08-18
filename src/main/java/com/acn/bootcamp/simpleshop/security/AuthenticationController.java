package com.acn.bootcamp.simpleshop.security;

import com.acn.bootcamp.simpleshop.Constants;
import com.acn.bootcamp.simpleshop.data.dto.AuthenticationResponseDto;
import com.acn.bootcamp.simpleshop.data.dto.UserCredentialDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping( path = Constants.AUTH_PATH, produces = "application/json")
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
    public ResponseEntity authenticate(@RequestBody UserCredentialDto credential) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credential.getUsername(), credential.getPassword()));
        } catch (final Exception e)
        {
            log.warn("Caught %s while authenticating credential".formatted(e.getMessage()));
            return ResponseEntity
                    .status(401)
                    .body(e.getMessage());
        }
        final var userDetails = identityService.loadUserByUsername(credential.getUsername());
        final var payload = new AuthenticationResponseDto(jwtService.generateToken(userDetails));
        return ResponseEntity.ok(payload);
    }


}
