package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity(name = SchemaDefinition.ENUM)
@Table(indexes = {
        @Index(name = "enum_idx_name", columnList = "name"),
        @Index(name = "enum_idx_uuid", columnList = "uuid"),
        @Index(name = "enum_idx_created_date", columnList = "createdDate"),
        @Index(name = "enum_idx_modified_date", columnList = "modifiedDate")
})
public class Enumeration extends AuditableDomainBase {

    @NotNull
    @Column(length = 64, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ENUM_GROUPS_ENUMS_FK"))
    private EnumerationGroup group;
}
