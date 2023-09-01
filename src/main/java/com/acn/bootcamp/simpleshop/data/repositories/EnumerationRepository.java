package com.acn.bootcamp.simpleshop.data.repositories;


import com.acn.bootcamp.simpleshop.data.domain.Enumeration;
import com.acn.bootcamp.simpleshop.data.domain.EnumerationGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnumerationRepository extends RepositoryBase<Enumeration> {
    List<Enumeration> findByGroup(EnumerationGroup group);
    Optional<Enumeration> findByName(String name);
}
