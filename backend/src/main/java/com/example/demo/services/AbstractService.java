package com.example.demo.services;

import com.example.demo.base.ErrorType;
import com.example.demo.exception.SampleException;
import com.example.demo.model.AbstractEntity;
import com.example.demo.repositories.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>>
        implements CommonService<E> {

    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }
    @Override
    public Optional<E> save(E entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        List<E> list = (List<E>) repository.saveAll(entities);
        return list;
    }

    @Override
    public Optional<E> update(E entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public Optional<E> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> getAll() {
        List<E> list = new ArrayList<>();
        repository.findAll().forEach(list::add); //fun with Java 8
        return list;
        //return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        E entity = get(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        repository.delete(entity);
        return !repository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        repository.deleteAll();
        List<E> list = new ArrayList<>();
        repository.findAll().forEach(list::add); //fun with Java 8
        return list.isEmpty();
        //return Lists.newArrayList(repository.findAll()).isEmpty();
    }

//другие методы, переопределённые из интерфейса
}
