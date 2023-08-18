package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = SchemaDefinition.PERSON)
@Getter @Setter @NoArgsConstructor
public class Person extends AuditableDomainBase {
    public Person(@NotNull String name, @NotNull String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    @NotNull
    String name;

    @NotNull
    String registrationNumber;

    @OneToMany(mappedBy = "owner")
    Set<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "owner")
    Set<Contact> contacts;

    @OneToMany(mappedBy = "owner")
    Set<User> accounts;

}
