package com.acn.bootcamp.simpleshop.data.repositories;


import com.acn.bootcamp.simpleshop.data.domain.Enumeration;
import com.acn.bootcamp.simpleshop.data.domain.EnumerationGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnumerationRepository extends RepositoryBase<Enumeration> {
    List<Enumeration> findByGroup(EnumerationGroup group);
    List<Enumeration> findByGroupName(String name);
}
