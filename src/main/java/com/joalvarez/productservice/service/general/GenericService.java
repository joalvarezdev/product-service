package com.joalvarez.productservice.service.general;

import java.util.List;
import java.util.Optional;

public interface GenericService<O, K> {

    List<O> getAll();

    Optional<O> get(K id);

    O save(O entity);

    O update(O entity);

    void deleteById(K id);
}
