package com.joalvarez.productservice.data.repository;

import com.joalvarez.productservice.data.domain.Product;
import com.joalvarez.productservice.data.repository.general.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends GenericRepository<Product, Integer> {}
