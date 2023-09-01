package com.acn.bootcamp.simpleshop.services;

import lombok.Synchronized;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
@Log4j2
public class EncryptionService {

    @Autowired
    private PasswordEncoder encoder;

    public EncryptionService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
    public String generatePasswordHash(String text)
    {
        return encoder.encode(text);
    }

    @Synchronized
    public String getSha256Hash(final String text) {
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
            log.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

}
