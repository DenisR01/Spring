package com.example.ShoeSellin.Repository;

import com.example.ShoeSellin.Model.Client;
import com.example.ShoeSellin.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
