package com.example.Mobilebanking1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MobileBankingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cif")
    private Customer customer;  // Changed 'Customer' to 'customer'
    @OneToMany(mappedBy = "mobileBankingUser", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Transaction> transaction = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "acctID")
    private Account account;
    private long acctNO;

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public MobileBankingUser setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
        return this;
    }

    public long getAcctNO() {
        return acctNO;
    }

    public MobileBankingUser setAcctNO(long acctNO) {
        this.acctNO = acctNO;
        return this;
    }

    private String username;
    private String pin;

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Customer getCustomer() {
        return this.customer;  // Changed 'Customer' to 'customer'
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;  // Changed 'Customer' to 'customer'
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}


/*@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class MobileBankingUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cif")
    private Customer Customer;
    @ManyToOne
    @JoinColumn(name = "acctID")
    private Account account;
    private String username;
    private String pin;

        public int getUserID() {
            return this.userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public Customer getCustomer() {
            return this.Customer;
        }

        public void setCustomer(Customer customer) {
            this.Customer = customer;
        }

        public Account getAccount() {
            return this.account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }

        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPin() {
            return this.pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }
    }
*/


