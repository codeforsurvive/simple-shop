package com.acn.bootcamp.simpleshop.data.domain;
import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity(name = SchemaDefinition.ENUM)
public class Enumeration extends AuditableDomainBase {

    @NotNull
    @Column(length = 64, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "ENUM_GROUPS_ENUMS_FK"))
    @JsonBackReference
    private EnumerationGroup group;
}
