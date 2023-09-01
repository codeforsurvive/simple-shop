package com.acn.bootcamp.simpleshop.services;

import com.acn.bootcamp.simpleshop.data.repositories.PersonRepository;
import com.acn.bootcamp.simpleshop.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    @Autowired
    public UserManagementService(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }


    public boolean
}
