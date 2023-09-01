package com.acn.bootcamp.simpleshop.services;

import com.acn.bootcamp.simpleshop.data.domain.Person;
import com.acn.bootcamp.simpleshop.data.domain.User;
import com.acn.bootcamp.simpleshop.data.repositories.PersonRepository;
import com.acn.bootcamp.simpleshop.data.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DataSeedingService {


    @Autowired
    public DataSeedingService() {
    }

    public void seedInitialData()
    {
        var john = new Person("John Doe", "123456789");
        var jean = new Person("Jean Doe", "987654321");
        personRepository.saveAll(Arrays.asList(john, jean));


    }

    private boolean isRequireSeeding () {
        return userRepository.count() > 0;
    }


}
