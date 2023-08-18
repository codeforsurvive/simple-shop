package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.ContactType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = SchemaDefinition.CONTACT)
@Getter @Setter @NoArgsConstructor
public class Contact extends AuditableDomainBase {

    public Contact(@NotNull Person owner, @NotNull String contactInfo, @NotNull ContactType contactType) {
        this(owner, contactInfo, contactType, false);
    }

    public Contact(@NotNull Person owner, @NotNull String contactInfo, @NotNull ContactType contactType, @NotNull boolean isPrimary) {
        this.contactInfo = contactInfo;
        this.contactType = contactType;
        this.isPrimary = isPrimary;
        this.owner = owner;
    }

    @NotNull @Column(name = "contact_info", length = 512, unique = true)
    private String contactInfo;

    @NotNull @Column(name = "type", length = 16)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @NotNull
    private Boolean isPrimary;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;
}
