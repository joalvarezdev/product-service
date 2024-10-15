package com.joalvarez.productservice.data.mapper;

import com.joalvarez.productservice.data.domain.Product;
import com.joalvarez.productservice.data.dto.ProductDTO;
import com.joalvarez.productservice.data.mapper.general.BaseMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, Product> {

    public ProductMapper(ObjectMapper mapper) {
        super(mapper);
    }
}
