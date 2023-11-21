package com.example.Mobilebanking1.Repository;
import com.example.Mobilebanking1.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account , Integer> {
   Account getByAcctNO(long accountNumber);
}
