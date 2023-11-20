package com.example.Mobilebanking1.Service;

import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Deposit {


        @Autowired
        private CustomerRepo customerRepo;

        @Autowired
        private AccountRepo accountRepo;

        @Autowired
        private TransactionRepo transactionRepo;

        @Autowired
        private MobileBankingUserRepo mobileBankingUserRepo;

        public Transaction depositMoney(int userId, double amount) {
            // Find the mobile banking user and their account
            MobileBankingUser user = mobileBankingUserRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            Account account = user.getAccount();
            Customer customer = user.getCustomer();

            // Add the amount to the account's balance
            account.setBalance(account.getBalance() + amount);
            accountRepo.save(account);

            // Create a new transaction
            Transaction transaction = new Transaction();
            transaction.setTransactionAmount(amount);
            transaction.setCreditedAccount(account);
            transaction.setMobileBankingUser(user);
            transaction.setCustomer(customer);
           // transaction.setTransactionDate((java.sql.Date) new Date());

            // Save the transaction
            transactionRepo.save(transaction);

            return transaction;
        }
    }


