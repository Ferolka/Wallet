package com.example.demo.repositories;

import com.example.demo.ViewModels.UserTransactionSum;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends CommonRepository<User> {

    @Query(value = "SELECT * FROM user WHERE login = ?1 ", nativeQuery = true)
    List<User> getUserByLogin(String login);

    @Query(value = "SELECT * FROM user WHERE id = ?1 ", nativeQuery = true)
    List<User> getUserById(Long id);

    @Query(value = "SELECT * FROM user WHERE login = (:login) AND password = (:password) ", nativeQuery = true)
    List<User> getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    @Modifying
    @Query(value = "INSERT INTO user (Name, Balance, Login, Password) VALUES (:name, :balance, :login, :password)", nativeQuery = true)
    @Transactional
    void insertUser(
            @Param("name") String name,
            @Param("balance") Double balance,
            @Param("login") String login,
            @Param("password") String password
    );
    @Query(value = "SELECT new com.example.demo.ViewModels.UserTransactionSum(Sum(t.Amount), t.userid,t.isincome)" +
            " FROM Transactions t " +
            "WHERE t.userid = ?1 and t.isincome = ?2 " +
            "group by t.userid ")
    UserTransactionSum userTransactionSum(Long userid, boolean isIncome);
}
