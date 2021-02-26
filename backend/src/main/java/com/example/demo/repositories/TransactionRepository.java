package com.example.demo.repositories;


import com.example.demo.model.Transactions;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends CommonRepository<Transactions> {
//    @Query(value = "SELECT * FROM transactions WHERE userid = ?1 ",nativeQuery = true)
//    List<Transactions> getUserTransactions(Long userid);
    //List<Transaction> getUserTransactions(@Param("userid") Long userid);
}
