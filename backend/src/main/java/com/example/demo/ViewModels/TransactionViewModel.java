package com.example.demo.ViewModels;

import com.example.demo.model.Transactions;

public class TransactionViewModel {
    private String Date;
    private double Amount;
    private boolean isincome;
    private String Comment;
    private String CategoryName;

    private String UserName;

    private String scheduledTransactionName;


    public TransactionViewModel convert(Transactions tran){
        return new TransactionViewModel(tran.getDate(),
                tran.getAmount(),
                tran.isIsincome(),
                tran.getComment(),
                tran.getCategory().getName(),
                tran.getUser().getName(),
                tran.getScheduledTransaction().getNextsend());
    }

    public TransactionViewModel(String date, double amount, boolean isincome, String comment, String categoryName, String userName, String scheduledTransactionName) {
        Date = date;
        Amount = amount;
        this.isincome = isincome;
        Comment = comment;
        CategoryName = categoryName;
        UserName = userName;
        this.scheduledTransactionName = scheduledTransactionName;
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

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getScheduledTransactionName() {
        return scheduledTransactionName;
    }

    public void setScheduledTransactionName(String scheduledTransactionName) {
        this.scheduledTransactionName = scheduledTransactionName;
    }
}
