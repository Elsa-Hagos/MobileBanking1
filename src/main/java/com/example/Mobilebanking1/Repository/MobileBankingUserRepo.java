package com.example.Mobilebanking1.Repository;
import com.example.Mobilebanking1.Model.MobileBankingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileBankingUserRepo extends JpaRepository<MobileBankingUser , Integer> {
}
