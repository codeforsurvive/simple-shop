package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = SchemaDefinition.PERSON)
@Getter @AllArgsConstructor
@Table(indexes = {
        @Index(name = "people_idx_name", columnList = "name"),
        @Index(name = "people_idx_number", columnList = "registrationNumber"),
        @Index(name = "people_idx_uuid", columnList = "uuid"),
        @Index(name = "people_idx_created_date", columnList = "createdDate"),
        @Index(name = "people_idx_modified_date", columnList = "modifiedDate")
})
public class Person extends AuditableDomainBase {
    public Person(@NotNull String name, @NotNull String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        bankAccounts = new HashSet<>();
        contacts = new HashSet<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @NotNull
    @Column(length = 128)
    private String name;

    @NotNull
    @Column(length = 32)
    private String registrationNumber;

    @OneToMany(mappedBy = "owner")
    Set<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "owner")
    Set<Contact> contacts;

    @OneToMany(mappedBy = "owner")
    Set<User> accounts;

}
