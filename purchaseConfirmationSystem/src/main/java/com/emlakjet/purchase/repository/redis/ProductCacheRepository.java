package com.emlakjet.purchase.repository.redis;

import com.emlakjet.purchase.entity.SimpleProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductCacheRepository extends CrudRepository<SimpleProduct, UUID> {
    void deleteByProductName(String name);
}
