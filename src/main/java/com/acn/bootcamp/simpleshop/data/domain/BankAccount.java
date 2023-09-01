package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import com.acn.bootcamp.simpleshop.data.enums.BankingServiceProvider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = SchemaDefinition.ACCOUNT)
@Getter @AllArgsConstructor
@Table(indexes = {
        @Index(name = "account_idx_number", columnList = "number"),
        @Index(name = "account_idx_provider", columnList = "provider"),
        @Index(name = "account_idx_uuid", columnList = "uuid"),
        @Index(name = "account_idx_created_date", columnList = "createdDate"),
        @Index(name = "account_idx_modified_date", columnList = "modifiedDate")
})
public class BankAccount extends AuditableDomainBase
{
    @NotNull
    @Column(length = 32, unique = true)
    private String number;

    @NotNull
    @Column(name = "provider", length = 32)
    @Enumerated(EnumType.STRING)
    private BankingServiceProvider serviceProvider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonBackReference
    private Person owner;

    public void updateAccountDetails(String number, BankingServiceProvider provider){
        this.number = number;
        this.serviceProvider = provider;
    }
}
