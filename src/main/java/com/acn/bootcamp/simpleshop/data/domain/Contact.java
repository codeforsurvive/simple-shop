package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.ContactType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity(name = SchemaDefinition.CONTACT)
@Getter
@Table(indexes = {
        @Index(name = "contact_idx_type", columnList = "type"),
        @Index(name = "contact_idx_primary", columnList = "primary"),
        @Index(name = "contact_idx_uuid", columnList = "uuid"),
        @Index(name = "contact_idx_created_date", columnList = "createdDate"),
        @Index(name = "contact_idx_modified_date", columnList = "modifiedDate")
})
public class Contact extends AuditableDomainBase {

    public Contact(@NotNull String contactInfo, @NotNull ContactType contactType) {
        this(contactInfo, contactType, false);
    }

    public Contact(@NotNull String contactInfo, @NotNull ContactType contactType, @NotNull Boolean primary) {
        this.contactInfo = contactInfo;
        this.contactType = contactType;
        this.primary = primary;
    }

    @NotNull @Column(name = "contact_info", length = 512, unique = true)
    private String contactInfo;

    @NotNull @Column(name = "type", length = 16)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @NotNull
    private Boolean primary;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;

    public  void togglePrimary() {
        primary = !primary;
    }

    public void updateContactDetail(ContactType type, String detail) {
        this.contactType = type;
        this.contactInfo = detail;
    }
}
