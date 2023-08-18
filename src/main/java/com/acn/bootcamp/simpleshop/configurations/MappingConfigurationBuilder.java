package com.acn.bootcamp.simpleshop.configurations;


import com.acn.bootcamp.simpleshop.data.domain.Contact;
import com.acn.bootcamp.simpleshop.data.domain.Person;
import com.acn.bootcamp.simpleshop.data.domain.User;
import com.acn.bootcamp.simpleshop.data.dto.ContactDto;
import com.acn.bootcamp.simpleshop.data.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class MappingConfigurationBuilder {

    private ModelMapper mapper;
    public MappingConfigurationBuilder() {
        mapper = new ModelMapper();
    }

    public MappingConfigurationBuilder addUserMappings()
    {
        var userToDtoMapper = mapper.createTypeMap(User.class, UserDto.class);
        userToDtoMapper.addMapping(User::getUsername, UserDto::setUsername);
        userToDtoMapper.addMappings(opt -> opt.skip(UserDto::setPassword));

        var personToUserDtoMapper = mapper.createTypeMap(Person.class, UserDto.class);
        personToUserDtoMapper.addMapping(Person::getName, UserDto::setName);
        personToUserDtoMapper.addMapping(Person::getRegistrationNumber, UserDto::setRegistrationNumber);

        return this;
    }

    public MappingConfigurationBuilder addContactMappings()
    {
        var propertyMapper = mapper.createTypeMap(Contact.class, ContactDto.class);
        propertyMapper.addMapping(Contact::getContactInfo, ContactDto::setInfo);
        propertyMapper.addMapping(Contact::getContactType, ContactDto::setType);

        return this;
    }

    public ModelMapper build()
    {
        return mapper;
    }
}
