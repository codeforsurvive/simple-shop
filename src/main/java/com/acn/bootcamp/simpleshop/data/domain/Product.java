package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = SchemaDefinition.PRODUCT)
@Getter @AllArgsConstructor
@Table(indexes = {
        @Index(name = "products_idx_name", columnList = "name"),
        @Index(name = "products_idx_price", columnList = "price"),
        @Index(name = "products_idx_stock", columnList = "stock"),
        @Index(name = "products_idx_available", columnList = "available"),
        @Index(name = "products_idx_uuid", columnList = "uuid"),
        @Index(name = "products_idx_created_date", columnList = "createdDate"),
        @Index(name = "products_idx_modified_date", columnList = "modifiedDate")
})
public class Product {
    public Product(@NotNull String name, @NotNull Double price, @NotNull Integer stock, User owner) {
        this(name, price, stock, true, owner, new HashSet<>());
    }

    public Product(@NotNull String name, @NotNull Double price, User owner) {
        this(name, price, 0, owner);
    }

    @NotNull
    @Column(length = 128)
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer stock;

    @NotNull
    private Boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductCategory> categories;
}
