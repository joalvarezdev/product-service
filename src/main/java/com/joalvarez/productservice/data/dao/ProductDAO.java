package com.joalvarez.productservice.data.dao;

import com.joalvarez.productservice.data.domain.Product;
import com.joalvarez.productservice.data.repository.ProductRepository;
import com.joalvarez.productservice.data.dao.general.BaseDAO;

import org.springframework.stereotype.Component;

@Component
public class ProductDAO extends BaseDAO<ProductRepository, Product, Integer> {

    public ProductDAO(ProductRepository repository) {
        super(repository);
    }
}
