package com.sales.catalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sales.catalog.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

}