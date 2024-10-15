package com.joalvarez.productservice.controller.general;

import com.joalvarez.productservice.data.dao.general.GenericDAO;
import com.joalvarez.productservice.data.dto.general.BaseDTO;
import com.joalvarez.productservice.data.mapper.general.GenericMapper;
import com.joalvarez.productservice.service.general.BaseService;

public class BasicController<S extends BaseService<D, M, O, K, E>, D extends GenericDAO<E, K>, M extends GenericMapper<O, E>, O extends BaseDTO, K, E> implements GenericController<K, O, S>{

    protected final S service;

    public BasicController(S service) {
        this.service = service;
    }
}