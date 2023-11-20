package com.example.Mobilebanking1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Mobilebanking1.Model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
