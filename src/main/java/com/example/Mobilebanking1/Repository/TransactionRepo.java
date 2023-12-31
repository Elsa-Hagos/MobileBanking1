package com.example.Mobilebanking1.Repository;
import com.example.Mobilebanking1.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByCustomer(Customer customer);
    List<Transaction> findTop5ByOrderByTransactionDateDesc();
}



