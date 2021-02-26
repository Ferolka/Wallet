package com.example.demo.model;





import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.DateFormat;

@Entity
public class Transactions extends AbstractEntity {


    //private int UserId;
    //private Long schtransactionid;
    private DateFormat Date;
    private double Amount;
    private boolean isincome;
    private String Comment;



   // @ManyToOne(optional = false)
//    @JoinColumn(name = "categoryid",referencedColumnName = "id")
//    private int categoryid;

//    public int getUserId() {
//        return UserId;
//    }
//
//    public void setUserId(int userId) {
//        UserId = userId;
//    }

//    public Long getSchtransactionid() {
//        return schtransactionid;
//    }
//
//    public void setSchtransactionid(Long schtransactionid) {
//        this.schtransactionid = schtransactionid;
//    }

    public DateFormat getDate() {
        return Date;
    }

    public void setDate(DateFormat date) {
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
    @ManyToOne (optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="categoryid")
    private Category Category;
    @ManyToOne (optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="userid")
    private User User;
    @ManyToOne (optional=false, cascade= CascadeType.ALL)
    @JoinColumn (name="SchTransactionId")
    private ScheduledTransaction ScheduleTran;

//    public Category getCategory() {
//        return categoryid;
//    }
//
//    public void setCategory(Category categoryid) {
//        this.categoryid = categoryid;
//    }
}
