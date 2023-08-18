package com.acn.bootcamp.simpleshop.data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class AuditableDomainBase extends DomainBase {


    protected AuditableDomainBase() {
        createdDate = new Date();
    }

    @NotNull
    @Column(name = "created_date", columnDefinition = "timestamp default current_timestamp")
    @CreatedDate
    protected Date createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    protected Date modifiedDate;
}
