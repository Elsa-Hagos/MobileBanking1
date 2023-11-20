package com.example.Mobilebanking1.Service;

import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionHistory {


        @Autowired
        private CustomerRepo customerRepo;

        @Autowired
        private TransactionRepo transactionRepo;

        public List<TransactionDetails> getTransactionHistory(int cif) {
            // Find the customer
            Customer customer = customerRepo.findById(cif).orElseThrow(() -> new RuntimeException("Customer not found"));

            // Get the customer's transactions
            List<Transaction> transactions = transactionRepo.findByCustomer(customer);

            // Convert the transactions to TransactionDetails objects
            List<TransactionDetails> transactionDetails = transactions.stream()
                    .map(transaction -> {
                        Account debitedAccount = transaction.getDebitedAccount();
                        long acctNO = debitedAccount != null ? debitedAccount.getAcctNO() : 0;

                        return new TransactionDetails(
                                customer.getFirstName(),
                                customer.getLastName(),
                                // transaction.getDebitedAccount().getAcctNO(),
                                acctNO,
                                transaction
                        );
                    }     )
                    .collect(Collectors.toList());

            return transactionDetails;
        }

        // Assuming you have a TransactionDetails class like this:
        public static class TransactionDetails {
            private String firstName;
            private String lastName;
            private long acctNO;
            private Transaction transaction;

            public TransactionDetails(String firstName, String lastName, long acctNO, Transaction transaction) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.acctNO = acctNO;
                this.transaction = transaction;
            }

            // Getters and setters...
            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public long getAcctNO() {
                return acctNO;
            }

            public void setAcctNO(long acctNO) {
                this.acctNO = acctNO;
            }
            public Transaction getTransaction() {
                return transaction;
            }

            public void setTransaction(Transaction transaction) {
                this.transaction = transaction;
            }
        }
    }


