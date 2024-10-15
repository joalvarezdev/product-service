package com.joalvarez.productservice.controller.general;

import com.joalvarez.productservice.service.general.GenericService;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController<K, O, S extends GenericService<O, K>> {

    default ResponseEntity<List<O>> getAll(S service) {
        List<O> entities = service.getAll();
        return ResponseEntity.ok(entities);
    }

    default ResponseEntity<O> get(S service, K id) {
        return ResponseEntity.of(service.get(id));
    }

    default ResponseEntity<O> save(S service, O entity) {
        O dto = service.save(entity);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.badRequest().build();
    }

    default ResponseEntity<O> update(S service, O entity) {
        O dto = service.update(entity);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.badRequest().build();
    }

    default void deleteById(S service, K id) {
        service.deleteById(id);
    }
}