package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.EnumGroup;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@Entity(name = SchemaDefinition.ENUM_GROUP)
public class EnumerationGroup extends AuditableDomainBase {
    @NotNull
    @Column(length = 64)
    @Enumerated(EnumType.STRING)
    private EnumGroup name;


    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Enumeration> enumerations;
}
