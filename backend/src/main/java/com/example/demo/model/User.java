package com.example.demo.model;


import javax.persistence.*;

import com.example.demo.model.Transactions;
import java.util.List;


@Entity
public class User extends AbstractEntity{

    @Column
    private String Name;
    @Column
    private String Password;
    @Column
    private String Login;
    @Column
    private double Balance;
    @OneToMany(mappedBy="user", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Transactions> transactions;

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
}
    //private String imageUrl;


