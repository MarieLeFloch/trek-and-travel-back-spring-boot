package com.ecommerce.trek_and_travel.repository;

import com.ecommerce.trek_and_travel.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
}
