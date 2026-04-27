package org.example.springboottest2.SS15.Repository;

import org.example.springboottest2.SS15.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}