package com.acn.bootcamp.simpleshop.configurations;


import com.acn.bootcamp.simpleshop.data.domain.BankAccount;
import com.acn.bootcamp.simpleshop.data.domain.Contact;
import com.acn.bootcamp.simpleshop.data.domain.Person;
import com.acn.bootcamp.simpleshop.data.domain.User;
import com.acn.bootcamp.simpleshop.data.dto.BankAccountDto;
import com.acn.bootcamp.simpleshop.data.dto.ContactDto;
import com.acn.bootcamp.simpleshop.data.dto.UserProfile;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;

public class MappingConfigurationBuilder {

    private final ModelMapper mapper;
    public MappingConfigurationBuilder() {
        mapper = new ModelMapper();
    }

    private<S, D> TypeMap<S, D> useTypeMap(Class<S> sourceType, Class<D> destinationType) {
        var mapping = mapper.getTypeMap(sourceType, destinationType);

        if(mapping == null) {
            return  mapper.createTypeMap(sourceType, destinationType);
        }
        return  mapping;
    }
    private<S, D> S getMapSource(Class<S> sourceType, Provider.ProvisionRequest<D> provider) {
        return sourceType.cast(provider.getSource());
    }

    public MappingConfigurationBuilder addUserMappings()
    {
        var dtoToUserMap = useTypeMap(UserProfile.class, User.class);
        dtoToUserMap.setProvider(provider -> {
            var source = getMapSource(UserProfile.class, provider);
            return new User(source.getUsername(), source.getPassword(), source.getRole().name());
        });

        var userToDtoMap = useTypeMap(User.class, UserProfile.class);
        userToDtoMap.addMapping(User::getUsername, UserProfile::setUsername);
        userToDtoMap.addMappings(opt -> opt.skip(UserProfile::setPassword));

        var personToUserMapper = useTypeMap(Person.class, UserProfile.class);
        personToUserMapper.addMapping(Person::getName, UserProfile::setName);


        return this;
    }

    public MappingConfigurationBuilder addContactMappings()
    {

        var domainToDtoMap = useTypeMap(Contact.class, ContactDto.class);
        domainToDtoMap.setProvider(provider -> {
            var source = getMapSource(Contact.class, provider);
            return new ContactDto(source.getContactType(), source.getContactInfo(), source.getPrimary());
        });

        var dtoToDomainMap = useTypeMap(ContactDto.class, Contact.class);
        dtoToDomainMap.setProvider(provider -> {
            var source = getMapSource(ContactDto.class, provider);
            return new Contact(source.info(), source.type(), source.primary());
        });

        return this;
    }

    public MappingConfigurationBuilder addBankAccountMappings() {
        var domainToDto = useTypeMap(BankAccount.class, BankAccountDto.class);
        domainToDto.setProvider(provider -> {
            var source = getMapSource(BankAccount.class, provider);
            return new BankAccountDto(source.getNumber(), source.getServiceProvider());
        });
        return this;
    }

    public ModelMapper build()
    {
        return mapper;
    }
}
