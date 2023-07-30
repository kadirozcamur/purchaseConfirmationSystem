package com.emlakjet.purchase.repository;

import com.emlakjet.purchase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
