package com.emlakjet.purchase.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


import java.io.Serializable;
import java.util.UUID;

/**
 * The type Simple product.
 */
@RedisHash(value = "product", timeToLive = 3600)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleProduct implements Serializable {
    @Id
    private UUID uuid;
    private String productName;
}
