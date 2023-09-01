package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.EnumGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;


@Getter
@AllArgsConstructor
@Entity(name = SchemaDefinition.ENUM_GROUP)
@Table(indexes = {
        @Index(name = "enum_group_idx_name", columnList = "name"),
        @Index(name = "enum_group_idx_uuid", columnList = "uuid"),
        @Index(name = "enum_group_idx_created_date", columnList = "createdDate"),
        @Index(name = "enum_group_idx_modified_date", columnList = "modifiedDate")
})
public class EnumerationGroup extends AuditableDomainBase {
    @NotNull
    @Column(length = 64)
    @Enumerated(EnumType.STRING)
    private EnumGroup name;


    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Enumeration> enumerations;
}
