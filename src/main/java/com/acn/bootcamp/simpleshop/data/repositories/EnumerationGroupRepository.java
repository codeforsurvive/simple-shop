package com.acn.bootcamp.simpleshop.data.repositories;

import com.acn.bootcamp.simpleshop.data.domain.EnumerationGroup;
import com.acn.bootcamp.simpleshop.data.enums.EnumGroup;
import org.springframework.stereotype.Repository;

@Repository
public interface EnumerationGroupRepository extends RepositoryBase<EnumerationGroup> {
    EnumerationGroup findByName(EnumGroup name);
}
