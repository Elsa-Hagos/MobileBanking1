package com.example.Mobilebanking1.Model;

import jakarta.persistence.*;

import java.sql.Date;
@Entity
public class Transaction {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int transactionID;
      // @ManyToOne
      // @JoinColumn(name = "transactionCode")
      // private TransactionCode transactionCode;
        private double transactionAmount;
        @ManyToOne
        @JoinColumn(name = "debitedAccountID")
        private Account debitedAccount;
        @ManyToOne
        @JoinColumn(name = "creditedAccountID")
        private Account creditedAccount;
        private Date transactionDate;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userID")
        private MobileBankingUser mobileBankingUser;
        @ManyToOne
        @JoinColumn(name = "cif")
        private Customer customer;

        //geters and seters
        public long getTransactionID() {
            return transactionID;
        }

        public void setTransactionID(Integer transactionID) {
            this.transactionID = transactionID;
        }

       // public TransactionCode getTransactionCode() {return transactionCode; }
    //public void setTransactionCode(TransactionCode transactionCode) {this.transactionCode = transactionCode;}

        public double getTransactionAmount() {
            return transactionAmount;
        }

        public void setTransactionAmount(double transactionAmount) {
            this.transactionAmount = transactionAmount;
        }

        public Account getDebitedAccount() {
            return debitedAccount;
        }

        public void setDebitedAccount(Account debitedAccount) {
            this.debitedAccount = debitedAccount;
        }

        public Account getCreditedAccount() {
            return creditedAccount;
        }

        public void setCreditedAccount(Account creditedAccount) {
            this.creditedAccount = creditedAccount;
        }

        public Date getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(Date transactionDate) {
            this.transactionDate = transactionDate;
        }

        public MobileBankingUser getMobileBankingUser() {
            return mobileBankingUser;
        }

        public void setMobileBankingUser(MobileBankingUser mobileBankingUser) {this.mobileBankingUser = mobileBankingUser;}

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }


    }

