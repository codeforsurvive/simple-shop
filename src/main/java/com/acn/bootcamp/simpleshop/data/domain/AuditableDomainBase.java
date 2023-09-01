package com.acn.bootcamp.simpleshop.data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class AuditableDomainBase extends DomainBase {
    protected AuditableDomainBase() {
        createdDate = new Date();
    }

    @NotNull
    @Column(unique = true, updatable = false, columnDefinition = "uuid default random_uuid()")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    protected UUID uuid;

    @NotNull
    @Column(columnDefinition = "timestamp default current_timestamp")
    @CreatedDate
    protected Date createdDate;

    @LastModifiedDate
    protected Date modifiedDate;
}
