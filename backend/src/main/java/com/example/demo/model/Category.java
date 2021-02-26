package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {
    private String Name;
    private boolean Outcome;
    private String Icon;
//    @OneToMany(mappedBy="category")
//    private Set<Transaction> transactions;

    @OneToMany (mappedBy="transactions", fetch= FetchType.EAGER)
    private Collection<com.example.demo.model.Transactions> Transactions;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public boolean isOutcome() {
        return Outcome;
    }

    public void setOutcome(boolean outcome) {
        Outcome = outcome;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }
}
