package com.joalvarez.productservice.data.dao.general;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<E, K> {

    Optional<E> findById(K id);

    List<E> findAll();

    E update(E entity);

    E save(E entity);

    void deleteById(K id);
}