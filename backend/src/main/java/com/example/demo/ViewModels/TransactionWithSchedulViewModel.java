package com.example.demo.ViewModels;

import com.example.demo.model.Transactions;

public class TransactionWithSchedulViewModel {
    private String Date;
//    private double Amount;
//    private boolean isincome;
//    private String Comment;
    private Long categoryid;
//    private Long userid;
//    private Long schtransactionid;
    private Long TranId;


//    private String UserName;
//
//    private String scheduledTransactionName;
//    private double SchAmount;
    private String nextsend;
//    private String Schedule;
//    private short Status;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

//    public double getAmount() {
//        return Amount;
//    }
//
//    public void setAmount(double amount) {
//        Amount = amount;
//    }
//
//    public boolean isIsincome() {
//        return isincome;
//    }
//
//    public void setIsincome(boolean isincome) {
//        this.isincome = isincome;
//    }
//
//    public String getComment() {
//        return Comment;
//    }
//
//    public void setComment(String comment) {
//        Comment = comment;
//    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

//    public Long getUserid() {
//        return userid;
//    }
//
//    public void setUserid(Long userid) {
//        this.userid = userid;
//    }
//
//    public Long getSchtransactionid() {
//        return schtransactionid;
//    }
//
//    public void setSchtransactionid(Long schtransactionid) {
//        this.schtransactionid = schtransactionid;
//    }

    public Long getTranId() {
        return TranId;
    }

    public void setTranId(Long tranId) {
        TranId = tranId;
    }

//    public String getUserName() {
//        return UserName;
//    }
//
//    public void setUserName(String userName) {
//        UserName = userName;
//    }
//
//    public String getScheduledTransactionName() {
//        return scheduledTransactionName;
//    }
//
//    public void setScheduledTransactionName(String scheduledTransactionName) {
//        this.scheduledTransactionName = scheduledTransactionName;
//    }
//
//    public double getSchAmount() {
//        return SchAmount;
//    }
//
//    public void setSchAmount(double schAmount) {
//        SchAmount = schAmount;
//    }

    public String getNextsend() {
        return nextsend;
    }

    public void setNextsend(String nextsend) {
        this.nextsend = nextsend;
    }

//    public String getSchedule() {
//        return Schedule;
//    }
//
//    public void setSchedule(String schedule) {
//        Schedule = schedule;
//    }
//
//    public short getStatus() {
//        return Status;
//    }
//
//    public void setStatus(short status) {
//        Status = status;
//    }
}
