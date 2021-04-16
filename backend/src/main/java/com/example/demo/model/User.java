package com.example.demo.model;


import javax.persistence.*;

import com.example.demo.model.Transactions;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.data.repository.cdi.Eager;

import java.util.List;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schtransactions","transactions"})
public class User extends AbstractEntity{

    @Column
    private String Name;
    @Column
    private String Password;
    @Column
    private String Login;
    @Column
    private double Balance;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private List<Transactions> transactions;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private List<ScheduledTransaction> schtransactions;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public List<ScheduledTransaction> getSchtransactions() {
        return schtransactions;
    }

    public void setSchtransactions(List<ScheduledTransaction> schtransactions) {
        this.schtransactions = schtransactions;
    }
}
    //private String imageUrl;


