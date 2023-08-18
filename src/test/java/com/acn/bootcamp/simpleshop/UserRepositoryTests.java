package com.acn.bootcamp.simpleshop;

import com.acn.bootcamp.simpleshop.data.domain.User;
import com.acn.bootcamp.simpleshop.data.enums.Role;
import com.acn.bootcamp.simpleshop.data.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    public void addNewValidUser_shouldAddUserToRepository()
    {
        var newUser = new User("john.doe", "123", Role.ADMINISTRATOR);
        userRepository.save(newUser);
        Assertions.assertTrue(newUser.getId() > 0);
    }


}
