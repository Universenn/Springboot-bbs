package com.mustache.bbs3.repository;

import com.mustache.bbs3.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
