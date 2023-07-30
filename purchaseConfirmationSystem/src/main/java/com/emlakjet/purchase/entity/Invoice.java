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
 * The type Invoice.
 */
@Data
@Entity(name = "invoice")
@Table(name = "invoice")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends BaseEntity implements Serializable {
    @Column(name = "uuid", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;
    private double amount;
    private String productName;
    private String billNo;
    private boolean approved;
    @Column(name = "expert_id")
    private Long expertId;
    @ManyToOne
    @JoinColumn(name = "expert_id", insertable = false, updatable = false)
    private Expert expert;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;
}
