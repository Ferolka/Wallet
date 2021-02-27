package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "scheduled_transaction")
public class ScheduledTransaction extends AbstractEntity{
    private double Amount;
    private String nextsend;
    private String Schedule;
    private short Status;
    @OneToMany(mappedBy="scheduledTransaction", fetch= FetchType.EAGER)
    private Collection<Transactions> Transactions;
    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getNextsend() {
        return nextsend;
    }

    public void setNextsend(String nextsend) {
        this.nextsend = nextsend;
    }

    public String getSchedule() {
        return Schedule;
    }

    public void setSchedule(String schedule) {
        Schedule = schedule;
    }

    public short getStatus() {
        return Status;
    }

    public void setStatus(short status) {
        Status = status;
    }

    public Collection<com.example.demo.model.Transactions> getTransactions() {
        return Transactions;
    }

    public void setTransactions(Collection<com.example.demo.model.Transactions> transactions) {
        Transactions = transactions;
    }
}
