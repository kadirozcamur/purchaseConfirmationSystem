package com.emlakjet.purchase.entity;

import com.emlakjet.purchase.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * The type Product.
 */
@Data
@Entity(name = "product")
@Table(name = "product")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity implements Serializable {
    @Column(name = "uuid", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;
    private String productName;
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
    private Invoice invoice;
}
