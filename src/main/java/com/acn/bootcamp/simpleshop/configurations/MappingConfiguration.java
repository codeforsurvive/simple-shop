package com.acn.bootcamp.simpleshop.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {

    @Bean
    public ModelMapper getMappingConfiguration()
    {
        var mappingConfigurationBuilder = new MappingConfigurationBuilder();

        mappingConfigurationBuilder
                .addContactMappings()
                .addBankAccountMappings()
                .addUserMappings();

        return mappingConfigurationBuilder.build();
    }
}
