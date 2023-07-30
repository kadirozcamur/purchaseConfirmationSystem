package com.emlakjet.purchase.entity;

import com.emlakjet.purchase.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * The type Expert.
 */
@Data
@Entity(name = "expert")
@Table(name = "expert")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Expert extends BaseEntity implements Serializable {
    @Column(name = "uuid", columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;
    private String name;
    private String lastName;
    @Column(unique = true)
    private String mail;
}
