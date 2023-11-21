package com.example.Mobilebanking1.Service;

import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Transfer {


        @Autowired
        private AccountRepo accountRepo;

        @Autowired
        private TransactionRepo transactionRepo;

        @Autowired
        private MobileBankingUserRepo mobileBankingUserRepo;

       /* public Transaction transferMoney(int fromUserId, int toUserId, double amount) {
            // Find the accounts of the users
            MobileBankingUser fromUser = mobileBankingUserRepo.findById(fromUserId).orElseThrow(() -> new RuntimeException("User not found"));
            MobileBankingUser toUser = mobileBankingUserRepo.findById(toUserId).orElseThrow(() -> new RuntimeException("User not found"));

            Account fromAccount = fromUser.getAccount();
            Account toAccount = toUser.getAccount();

            // Check if the fromAccount has enough balance
            if (fromAccount.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance");
            }

            // Deduct the amount from the fromAccount's balance and add it to the toAccount's balance
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);

            accountRepo.save(fromAccount);
            accountRepo.save(toAccount);

            // Create a new transaction for the transfer
            Transaction transaction = new Transaction();
            transaction.setTransactionAmount(amount);
            transaction.setDebitedAccount(fromAccount);
            transaction.setCreditedAccount(toAccount);
            transaction.setMobileBankingUser(fromUser);
            transaction.setCustomer(fromUser.getCustomer());
          //  transaction.setTransactionDate(new java.util.Date());

            // Save the transaction
            transactionRepo.save(transaction);

            return transaction;
        }*/

       public String transferMoney(long fromAccountNumber, long toAccountNumber, double amount) {
           Account fromAccount = accountRepo.getByAcctNO(fromAccountNumber);
           Account toAccount = accountRepo.getByAcctNO(toAccountNumber);

           if (fromAccount != null && toAccount != null && fromAccount.getBalance()>=amount) {
               fromAccount.setBalance(fromAccount.getBalance() - amount);
               toAccount.setBalance(toAccount.getBalance() + amount);

               // Update account balances in the database
               accountRepo.save(fromAccount);
               accountRepo.save(toAccount);

               // Record the fund transfer
               Transaction fundTransfer = new Transaction();
               fundTransfer.setDebitAccount(fromAccountNumber);
               fundTransfer.setCreditAccount(toAccountNumber);
               fundTransfer.setAmount(amount);
               //fundTransfer.setTransactionDate(LocalDateTime.now());
               transactionRepo.save(fundTransfer);

               return "Funds transferred successfully";
           }
           else{
               return "Fund transfer UnSuccesfull";
           }
       }
    }



