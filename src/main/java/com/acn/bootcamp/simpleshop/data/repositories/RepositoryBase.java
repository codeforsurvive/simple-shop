package com.acn.bootcamp.simpleshop.data.repositories;

import com.acn.bootcamp.simpleshop.data.domain.DomainBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBase<T extends DomainBase> extends JpaRepository<T, Integer>
{
}
