package com.joalvarez.productservice.service.general;

import com.joalvarez.productservice.data.dao.general.GenericDAO;
import com.joalvarez.productservice.data.dto.general.BaseDTO;
import com.joalvarez.productservice.data.mapper.general.GenericMapper;

import java.util.List;
import java.util.Optional;

public class BaseService<D extends GenericDAO<E, K>, M extends GenericMapper<O, E>, O extends BaseDTO, K, E> implements GenericService<O, K> {

    protected final D dao;
    protected final M mapper;

    public BaseService(D dao, M mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<O> getAll() {
        return this.mapper.toDTOs(this.dao.findAll());
    }

    @Override
    public Optional<O> get(K id) {
        return this.dao.findById(id)
                .map(this.mapper::toDTO);
    }

    @Override
    public O save(O entity) {
        return this.mapper.toDTO(
                this.dao.save(
                        this.mapper.fromDTO(entity)
                )
        );
    }

    @Override
    public O update(O entity) {
        return this.save(entity);
    }

    @Override
    public void deleteById(K id) {
        this.dao.deleteById(id);
    }
}
