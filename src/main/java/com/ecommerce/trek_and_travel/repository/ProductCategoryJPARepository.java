package com.ecommerce.trek_and_travel.repository;

import com.ecommerce.trek_and_travel.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category") // personnalisation endpoint API
public interface ProductCategoryJPARepository extends JpaRepository<ProductCategory, Long> {
}
