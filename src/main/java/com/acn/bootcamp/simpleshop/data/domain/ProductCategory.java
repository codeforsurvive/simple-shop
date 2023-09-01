package com.acn.bootcamp.simpleshop.data.domain;

import com.acn.bootcamp.simpleshop.data.SchemaDefinition;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
@Entity(name = SchemaDefinition.PRODUCT_CATEGORY)
@Getter
public class ProductCategory extends DomainBase {

    public ProductCategory(Product product, Enumeration category)
    {
        this.product = product;
        this.category = category;
    }
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PRODUCT_CATEGORY_PRODUCT_FK"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "PRODUCT_CATEGORY_CATEGORY_FK"))
    private Enumeration category;
}
