package com.acn.bootcamp.simpleshop.services;

import com.acn.bootcamp.simpleshop.configurations.jwt.JwtConfiguration;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.Synchronized;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.Instant;

@Service
@Log4j2
public class JwtService {


    private final JwtConfiguration configuration;
    private final Algorithm hmac512;
    private final JWTVerifier verifier;


    @Autowired
    public JwtService(JwtConfiguration configuration) {
        this.configuration = configuration;
        var hashedKey = getSha256Hash(configuration.getSecretKey());
        hmac512 = Algorithm.HMAC512(hashedKey);
        verifier = JWT.require(hmac512).build();
    }

    @Synchronized
    private String getSha256Hash(final String text) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(text.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public String generateToken(final UserDetails userDetails) {
        final Instant now = Instant.now();
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withIssuer(configuration.getIssuer())
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(configuration.getValidity()))
                .sign(hmac512);
    }

    public String validateTokenAndGetUsername(final String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (final JWTVerificationException verificationEx) {
            log.warn("token invalid: {}", verificationEx.getMessage());
            return null;
        }
    }
}
