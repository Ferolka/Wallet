package com.example.demo.ViewModels;

public class UserTransactionSum {
    private Long userid;
    private double Total;
    private boolean isIncome;



    public UserTransactionSum(double total, Long userid,boolean isIncome) {
        this.userid = userid;
        Total = total;
        this.isIncome=isIncome;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }
}
