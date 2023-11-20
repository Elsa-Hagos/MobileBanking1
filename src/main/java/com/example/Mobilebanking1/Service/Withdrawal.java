package com.example.Mobilebanking1.Service;
import com.example.Mobilebanking1.Model.*;

import com.example.Mobilebanking1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class Withdrawal {


        @Autowired
        private CustomerRepo customerRepo;

        @Autowired
        private AccountRepo accountRepo;

        @Autowired
        private TransactionRepo transactionRepo;

        @Autowired
        private MobileBankingUserRepo mobileBankingUserRepo;

    public Transaction withdrawMoney(Integer userId, double amount) {
        // Find the mobile banking user and their account
        MobileBankingUser user = mobileBankingUserRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Account account = user.getAccount();
        Customer customer= user.getCustomer();

        // Check if the account has enough balance
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // Deduct the amount from the account's balance
        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);
        // Create a new transaction
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(amount);
        transaction.setDebitedAccount(account);
        transaction.setMobileBankingUser(user);
        transaction.setCustomer(customer);
       // transaction.setTransactionDate((java.sql.Date) new Date());

        // Save the transaction
        transactionRepo.save(transaction);

        return transaction;
    }

    }


