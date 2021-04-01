package com.example.demo.services;

import com.example.demo.ViewModels.CategorySum;
import com.example.demo.ViewModels.TransactionWithSchedulViewModel;
import com.example.demo.model.Transactions;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractService<Transactions, TransactionRepository> {

    public TransactionService(TransactionRepository repository) {
        super(repository);
    }
//    @PersistenceContext
//    private EntityManager em;


    public List<Transactions> getUserTransaction(Long userId) {

        //List<Transactions> res = repository.getUserTransactions(userId);
        return repository.getUserTransactions(userId);

    }
    public List<TransactionWithSchedulViewModel> withScheduled(Long userId) {
        return repository.withScheduled(userId);

    }
    public List<CategorySum> categorySum(Long userId) {
        return repository.categorySum(userId);

    }



}
