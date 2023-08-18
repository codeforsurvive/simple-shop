package com.acn.bootcamp.simpleshop.configurations.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
@Getter @Setter
public class JwtConfiguration {
    private String secretKey;
    private Integer validity;
    private String prefix;
    private String header;
    private String issuer;
}
