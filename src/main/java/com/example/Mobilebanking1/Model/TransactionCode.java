package com.example.Mobilebanking1.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TransactionCode {
    @Id
    private String transactionCode;
    private String transactionType;


    public String getTransactionCode() {return this.transactionCode;}

    public void setTransactionCode(String transactionCode) {this.transactionCode = transactionCode;}

    public String getTransactionType() {return this.transactionType;}

    public void setTransactionType(String transactionType) {this.transactionType = transactionType;}

}
