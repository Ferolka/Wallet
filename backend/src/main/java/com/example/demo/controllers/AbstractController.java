package com.example.demo.controllers;

import com.example.demo.base.ErrorType;
import com.example.demo.model.AbstractEntity;
import com.example.demo.repositories.CommonRepository;
import com.example.demo.services.CommonService;
import org.apache.jmeter.report.core.SampleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>>
        implements CommonController<E> {

    protected final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> save(@RequestBody E entity) {
        return service.save(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format("", entity.toString())
                ));
    }
    @Override
    public ResponseEntity<List<E>> saveAll(@RequestBody List<E> entities) {
        return ResponseEntity.ok(service.saveAll(entities));
    }

    @Override
    public ResponseEntity<E> update(@RequestBody E entity) {
        return service.update(entity).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_UPDATED.getDescription(), entity)
                ));
    }

    @Override
    public ResponseEntity<E> get(@RequestParam Long id) {
        return service.get(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new SampleException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

    @Override
    public ResponseEntity<List<E>> getAll() {
        return ResponseEntity.ok(service.getAll());
        //return "all";
    }


    @Override
    public Boolean delete(@RequestParam Long id) {
        return service.deleteById(id);
    }

    @Override
    public Boolean deleteAll() {
        return service.deleteAll();
    }

//другие методы
}