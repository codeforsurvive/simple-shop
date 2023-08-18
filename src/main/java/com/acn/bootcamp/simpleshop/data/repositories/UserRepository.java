package com.acn.bootcamp.simpleshop.data.repositories;

import com.acn.bootcamp.simpleshop.data.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends RepositoryBase<User>
{
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
