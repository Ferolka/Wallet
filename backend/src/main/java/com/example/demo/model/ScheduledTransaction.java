package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.text.DateFormat;
import java.util.Collection;

@Entity
public class ScheduledTransaction extends AbstractEntity{
    private double Amount;
    private DateFormat NextSend;
    private String Schedule;
    private short Status;
    @OneToMany(mappedBy="transactions", fetch= FetchType.EAGER)
    private Collection<Transactions> Transactions;
    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public DateFormat getNextSend() {
        return NextSend;
    }

    public void setNextSend(DateFormat nextSend) {
        NextSend = nextSend;
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
}
