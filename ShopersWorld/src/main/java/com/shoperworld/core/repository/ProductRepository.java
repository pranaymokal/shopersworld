package com.shoperworld.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoperworld.core.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
