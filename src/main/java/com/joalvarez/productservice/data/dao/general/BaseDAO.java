package com.joalvarez.productservice.data.dao.general;

import com.joalvarez.productservice.data.repository.general.GenericRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BaseDAO<R extends GenericRepository<E, K>, E, K> implements GenericDAO<E, K> {

	protected final R repository;

	public BaseDAO(R repository) {
		this.repository = repository;
	}

	@Override
	public Optional<E> findById(K id) {
		return this.repository.findById(id);
	}

	@Override
	public List<E> findAll() {
		return this.repository.findAll();
	}

	@Override
	public E update(E entity) {
		return this.repository.save(entity);
	}

	@Override
	public E save(E entity) {
		return this.repository.save(entity);
	}

	@Override
	public void deleteById(K id) {
		this.repository.deleteById(id);
	}
}