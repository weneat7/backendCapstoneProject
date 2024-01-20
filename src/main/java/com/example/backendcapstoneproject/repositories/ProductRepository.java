package com.example.backendcapstoneproject.repositories;

import com.example.backendcapstoneproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findByCategory_Name(String name);

    void deleteById(Long id);

    Product save(Product product);

    @Query("select  p from Product p where p.id = :id")
    Product findProductById(@Param("id")Long id);


}
