package com.joalvarez.productservice.controller;

import com.joalvarez.productservice.data.dao.ProductDAO;
import com.joalvarez.productservice.data.domain.Product;
import com.joalvarez.productservice.data.dto.ProductDTO;
import com.joalvarez.productservice.data.mapper.ProductMapper;
import com.joalvarez.productservice.service.ProductService;
import com.joalvarez.productservice.controller.general.BasicController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController
        extends BasicController<ProductService, ProductDAO, ProductMapper, ProductDTO, Integer, Product> {

    public ProductController(ProductService service) {
        super(service);
    }

	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

	@PostMapping
	public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO dto) {
		return ResponseEntity.ok(this.service.save(dto));
	}

	@GetMapping("{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.service.get(id).orElse(null));
	}
}
