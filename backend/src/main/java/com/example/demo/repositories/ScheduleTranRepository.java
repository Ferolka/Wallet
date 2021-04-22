package com.example.demo.repositories;

import com.example.demo.model.ScheduledTransaction;
import com.example.demo.model.Transactions;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleTranRepository  extends CommonRepository<ScheduledTransaction> {
    @Query(value = "SELECT * FROM scheduled_transaction WHERE userid = ?1 AND NOT status = '3' ORDER by nextsend",nativeQuery = true)
    List<ScheduledTransaction> getUserTransactions(Long userid);
}
