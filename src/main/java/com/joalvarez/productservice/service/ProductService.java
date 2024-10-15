package com.joalvarez.productservice.service;

import com.joalvarez.productservice.data.dao.ProductDAO;
import com.joalvarez.productservice.data.domain.Product;
import com.joalvarez.productservice.data.dto.ProductDTO;
import com.joalvarez.productservice.data.mapper.ProductMapper;
import com.joalvarez.productservice.service.general.BaseService;

import org.springframework.stereotype.Service;

@Service
public class ProductService
        extends BaseService<
                ProductDAO,
                ProductMapper,
                ProductDTO,
                Integer,
                Product> {

    public ProductService(ProductDAO dao, ProductMapper mapper) {
        super(dao, mapper);
    }
}