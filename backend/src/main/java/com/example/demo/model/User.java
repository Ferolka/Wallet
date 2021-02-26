package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;


@Entity
public class User extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private Long Id;
    private String Name;
    private String Password;
    private String Login;
    private double Balance;


    @OneToMany (mappedBy="transactions", cascade = CascadeType.ALL)
    private Set<Transactions> Transactions;
//    @OneToMany(mappedBy="transaction", fetch= FetchType.EAGER)
//    private Collection<Transaction> Transactions;
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }

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
}
    //private String imageUrl;


