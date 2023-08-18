package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.BankingServiceProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = SchemaDefinition.ACCOUNT)
@Getter @Setter @NoArgsConstructor
public class BankAccount extends AuditableDomainBase
{
    public BankAccount(@NotNull Person owner, @NotNull String number, @NotNull BankingServiceProvider serviceProvider) {
        this.owner = owner;
        this.number = number;
        this.serviceProvider = serviceProvider;
    }

    @NotNull
    @Column(length = 32, unique = true)
    private String number;

    @NotNull
    @Column(name = "provider", length = 32)
    @Enumerated(EnumType.STRING)
    private BankingServiceProvider serviceProvider;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Person owner;
}
