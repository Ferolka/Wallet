package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "scheduled_transaction")
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","transactions"})
public class ScheduledTransaction extends AbstractEntity{
    private double Amount;
    private String nextsend;
    private boolean Schedule;
    private short Status;
    private Long userid;
    @OneToMany(mappedBy="scheduledTransaction", fetch= FetchType.LAZY)
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

    public boolean getSchedule() {
        return Schedule;
    }

    public void setSchedule(boolean schedule) {
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
