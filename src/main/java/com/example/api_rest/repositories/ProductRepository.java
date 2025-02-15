package com.example.api_rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_rest.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
