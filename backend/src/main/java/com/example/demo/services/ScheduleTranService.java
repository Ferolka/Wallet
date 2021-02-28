package com.example.demo.services;

import com.example.demo.model.ScheduledTransaction;

import com.example.demo.repositories.ScheduleTranRepository;

import org.springframework.stereotype.Service;

@Service
public class ScheduleTranService extends AbstractService<ScheduledTransaction, ScheduleTranRepository> {

    public ScheduleTranService(ScheduleTranRepository repository) {
        super(repository);
    }

}
