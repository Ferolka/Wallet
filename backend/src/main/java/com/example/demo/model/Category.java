package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "category")
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","transactions","scheduledTransaction"})
public class Category extends AbstractEntity {
    @Column
    private String Name;
    private boolean Outcome;
    private String Icon;
//    @OneToMany(mappedBy="category")
//    private Set<Transaction> transactions;

    @OneToOne(mappedBy = "category",fetch= FetchType.LAZY)
    private ScheduledTransaction scheduledTransaction;

    @OneToMany (mappedBy="category")
    private Collection<Transactions> Transactions;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public boolean isOutcome() {
        return Outcome;
    }

    public void setOutcome(boolean outcome) {
        Outcome = outcome;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }
    public Collection<com.example.demo.model.Transactions> getTransactions() {
        return Transactions;
    }

    public void setTransactions(Collection<com.example.demo.model.Transactions> transactions) {
        Transactions = transactions;
    }

    public ScheduledTransaction getScheduledTransaction() {
        return scheduledTransaction;
    }

    public void setScheduledTransaction(ScheduledTransaction scheduledTransaction) {
        this.scheduledTransaction = scheduledTransaction;
    }
}
