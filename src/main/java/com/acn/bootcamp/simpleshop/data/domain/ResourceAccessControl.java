package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.AccessLevel;
import com.acn.bootcamp.simpleshop.data.enums.ResourceGroup;
import com.acn.bootcamp.simpleshop.data.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity(name = SchemaDefinition.RESOURCE_ACCESS_CONTROL)
@Getter @AllArgsConstructor
@Table(indexes = {
        @Index(name = "acl_idx_role", columnList = "role"),
        @Index(name = "acl_idx_access_level", columnList = "accessLevel"),
        @Index(name = "people_idx_resource_group", columnList = "resourceGroup")
})
public class ResourceAccessControl extends DomainBase {

    @NotNull @Column(length = 32)
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull @Column(length = 32)
    @Enumerated(EnumType.STRING)
    private AccessLevel accessLevel;

    @NotNull @Column(length = 64)
    @Enumerated(EnumType.STRING)
    private ResourceGroup resourceGroup;
}
