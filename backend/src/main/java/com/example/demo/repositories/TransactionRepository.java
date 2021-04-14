package com.example.demo.repositories;


import com.example.demo.ViewModels.CategorySum;
import com.example.demo.ViewModels.TransactionWithSchedulViewModel;
import com.example.demo.model.Transactions;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Lazy
public interface TransactionRepository extends CommonRepository<Transactions> {
    @Query(value = "SELECT * FROM transactions WHERE userid = ?1 ORDER by `date` desc",nativeQuery = true)
    List<Transactions> getUserTransactions(Long userid);

    @Query(value = "SELECT t.Id as TranId, t.categoryid as categoryid, t.Date as Date, s.nextsend as nextsend" +
            " FROM transactions t " +
            "left join scheduled_transaction s on s.Id=t.schtransactionid " +
            "WHERE userid = ?1 ",nativeQuery = true)
    List<TransactionWithSchedulViewModel> withScheduled(Long userid);

    @Query(value = "SELECT new com.example.demo.ViewModels.CategorySum(Sum(t.Amount), t.categoryid)" +
            " FROM Transactions t " +
            "WHERE t.userid = ?1 " +
            "group by t.categoryid ")
    List<CategorySum> categorySum(Long userid);
    @Query(value = "SELECT new com.example.demo.ViewModels.CategorySum(Sum(t.Amount), t.categoryid)" +
            " FROM Transactions t " +
            "WHERE t.userid = ?1 and t.isincome = ?2 " +
            "group by t.categoryid ")
    List<CategorySum> categoryProcent(Long userid, boolean isIncome);

}
