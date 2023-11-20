package com.example.Mobilebanking1.Repository;
import com.example.Mobilebanking1.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account , Integer> {
}
