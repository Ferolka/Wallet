package com.example.demo.services;

import com.example.demo.model.Transactions;

import com.example.demo.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TransactionService extends AbstractService<Transactions, TransactionRepository> {

    public TransactionService(TransactionRepository repository) {
        super(repository);
    }
//    @PersistenceContext
//    private EntityManager em;


//    public List<Transactions> getUserTransaction(Long userId) {
////        StringBuilder query = new StringBuilder("from Transaction ");
////
////            query.append(" where userId =").append(userId).append(" ");
////
////        return em.createQuery(query.toString(), Transaction.class).getResultList();
//
//
//        return repository.getUserTransactions(userId);
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Transaction> query = cb.createQuery(Transaction.class);
//        Root<Transaction> tran = query.from(Transaction.class);
//
//        Path<Long> userIdPath = tran.get("userId");
//
//        List<Predicate> predicates = new ArrayList<>();
//
//            predicates.add(cb.like(userIdPath,userId));
//
//        query.select(tran)
//                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
//
//        return entityManager.createQuery(query)
//                .getResultList();
   // }


}
