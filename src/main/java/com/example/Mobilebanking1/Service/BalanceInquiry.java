package com.example.Mobilebanking1.Service;

import com.example.Mobilebanking1.Model.Account;
import com.example.Mobilebanking1.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceInquiry {
    @Autowired
    private AccountRepo accountRepo;

    public double getAccountBalance(int acctId) {
        // Find the account
        Account account = accountRepo.findById(acctId).orElseThrow(() -> new RuntimeException("Account not found"));

        // Return the account's balance
        return account.getBalance();
    }
}

