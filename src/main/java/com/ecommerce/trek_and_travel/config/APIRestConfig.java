package com.ecommerce.trek_and_travel.config;

import com.ecommerce.trek_and_travel.entity.Product;
import com.ecommerce.trek_and_travel.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class APIRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry corsRegistry) {

        HttpMethod[] unsupportedHttpMethodsV1 = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.DELETE};

        // for V1, we just want a read-only API => GET
        // so we disable others HTTP methods for both entities : PUT, POST, DELETE and PATCH
        repositoryRestConfiguration.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedHttpMethodsV1))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedHttpMethodsV1));

        repositoryRestConfiguration.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedHttpMethodsV1))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(unsupportedHttpMethodsV1));

    }
}
