package com.example.Mobilebanking1.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Date;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import com.fasterxml.jackson.annotation.*;
//import java.sql.Date;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})


public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int acctID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cif")
    private Customer customer;

    @GeneratedValue
    private long acctNO;
    private double balance;
    private String accountStatus;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    private Date updatedDate;



    @PrePersist
    public void onPrePersist() {
        this.acctNO = generateAccountNumber();
    }

    private long generateAccountNumber() {
        long min = 1_000_000_000L; // 10 digits
        long max = 9_999_999_999L; // 10 digits
        return ThreadLocalRandom.current().nextLong(min, max + 1);

}
    public int getAcctID() {
        return acctID;
    }
    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer cif) {
        this.customer = cif;
    }

    public long getAcctNO() {
        return acctNO;
    }
    public void setAcctNO(long acctNO) {
        this.acctNO = acctNO;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }



}


