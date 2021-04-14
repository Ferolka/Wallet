package com.example.demo.model;









import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name="transactions")
@Transactional
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user","scheduledTransaction"})
public class Transactions extends AbstractEntity {


    //private int UserId;
    //private Long schtransactionid;
    private String Date;
    private double Amount;
    private boolean isincome;
    private String Comment;
   @Column(updatable = false,insertable = false)
    private Long categoryid;
    @Column(updatable = false,insertable = false)
    private Long userid;
    @Column(updatable = false,insertable = false)
    private Long schtransactionid;

    public Transactions(double amount, String comment, String date,
                        Category category, boolean isincome, ScheduledTransaction sch, User user) {
        Amount=amount;
        Comment=comment;
        Date=date;
        this.category=category;
        this.user=user;
        this.isincome=isincome;
        this.scheduledTransaction=sch;
    }

    @ManyToOne (fetch=FetchType.LAZY, cascade= CascadeType.REMOVE)
    @JoinColumn (name="categoryid")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY,cascade= CascadeType.REMOVE)
    @JoinColumn (name="userid")
    private User user;
    @ManyToOne (fetch = FetchType.LAZY, cascade= CascadeType.REMOVE)
    @JoinColumn (name="schtransactionid")
    private ScheduledTransaction scheduledTransaction;

    public Transactions() {

    }


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

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getSchtransactionid() {
        return schtransactionid;
    }

    public void setSchtransactionid(Long schtransactionid) {
        this.schtransactionid = schtransactionid;
    }


}
