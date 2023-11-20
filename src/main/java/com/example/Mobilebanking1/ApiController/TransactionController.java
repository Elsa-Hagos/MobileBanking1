package com.example.Mobilebanking1.ApiController;
import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TransactionController {
    @Autowired
    private Withdrawal withdrawal;
    @Autowired
    private Deposit deposit;
    @Autowired
    private Transfer transfer;


    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdrawMoney(@RequestBody Map<String, Object> payload) {
        Integer userId = (Integer) payload.get("userId");
        double amount = (Double) payload.get("amount");
         Transaction transaction = withdrawal.withdrawMoney(userId, amount);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    @PostMapping("/deposit")
    public ResponseEntity<Transaction> depositMoney(@RequestBody Map<String, Object> payload) {
        Integer userId = (Integer) payload.get("userId");
        double amount = (Double) payload.get("amount");
        Transaction transaction = deposit.depositMoney(userId, amount);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transferMoney(@RequestBody TransferRequest request) {
        Transaction transaction = transfer.transferMoney(request.getFromUserId(), request.getToUserId(), request.getAmount());
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    // Assuming you have a TransferRequest class like this:
    public static class TransferRequest {
        private int fromUserId;
        private int toUserId;
        private double amount;

        public int getFromUserId() {
            return fromUserId;
        }

        public void setFromUserId(int fromUserId) {
            this.fromUserId = fromUserId;
        }

        public int getToUserId() {
            return toUserId;
        }

        public void setToUserId(int toUserId) {
            this.toUserId = toUserId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
    @Autowired
    private TransactionHistory transactionHistory;

    @GetMapping("/transactionHistory/{cif}")
    public ResponseEntity<List<TransactionHistory.TransactionDetails>> getTransactionHistory(@PathVariable int cif) {
        List<TransactionHistory.TransactionDetails> transactionDetails = transactionHistory.getTransactionHistory(cif);
        return new ResponseEntity<>(transactionDetails, HttpStatus.OK);
    }


}

