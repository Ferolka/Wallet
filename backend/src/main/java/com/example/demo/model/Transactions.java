package com.example.demo.model;









import javax.persistence.*;

@Entity
@Table(name="transactions")
public class Transactions extends AbstractEntity {


    //private int UserId;
    //private Long schtransactionid;
    private String Date;
    private double Amount;
    private boolean isincome;
    private String Comment;

    @ManyToOne (optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="categoryid")
    private Category category;
    @ManyToOne
    @JoinColumn (name="userid")
    private User user;
    @ManyToOne (optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="schtransactionid")
    private ScheduledTransaction scheduledTransaction;



    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public boolean isIsincome() {
        return isincome;
    }

    public void setIsincome(boolean isincome) {
        this.isincome = isincome;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }


    public com.example.demo.model.Category getCategory() {
        return category;
    }

    public void setCategory(com.example.demo.model.Category category) {
        this.category = category;
    }

    public com.example.demo.model.User getUser() {
        return user;
    }

    public void setUser(com.example.demo.model.User user) {
        this.user = user;
    }

    public ScheduledTransaction getScheduledTransaction() {
        return scheduledTransaction;
    }

    public void setScheduledTransaction(ScheduledTransaction scheduledTransaction) {
        this.scheduledTransaction = scheduledTransaction;
    }
}
