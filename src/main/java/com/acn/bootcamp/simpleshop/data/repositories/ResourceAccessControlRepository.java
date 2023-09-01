package com.acn.bootcamp.simpleshop.data.repositories;


import com.acn.bootcamp.simpleshop.data.domain.ResourceAccessControl;
import com.acn.bootcamp.simpleshop.data.enums.AccessLevel;
import com.acn.bootcamp.simpleshop.data.enums.Role;

import java.util.List;

public interface ResourceAccessControlRepository extends RepositoryBase<ResourceAccessControl> {
    List<ResourceAccessControl> findByRole(Role role);
    List<ResourceAccessControl> findByAccessLevel(AccessLevel accessLevel);
}
