package com.example.demo.ViewModels;

public class CategorySum {
    private Long categoryid;
    private double Total;

    public Long getCategoryid() {
        return categoryid;
    }

    public CategorySum( double total,Long categoryid) {
        this.categoryid = categoryid;
        Total = total;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
}
