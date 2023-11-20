package com.example.Mobilebanking1.Service;
import com.example.Mobilebanking1.Repository.*;
import com.example.Mobilebanking1.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Create {
@Autowired
    private CustomerRepo customerRepo;
@Autowired
    private AccountRepo accountRepo;
public  Account createAccount(Account account) {
    Customer customer = account.getCustomer();
    customerRepo.save(customer);
    accountRepo.save(account);
    return account;
}
    @Autowired
    private MobileBankingUserRepo mobileBankingUserRepo;

    public MobileBankingUser createMobileBankingUser(MobileBankingUser mobileBankingUser) {
        // Save the customer and account first
        Customer customer = mobileBankingUser.getCustomer();
        Account account = mobileBankingUser.getAccount();
       // account.setCreatedDate((java.sql.Date) new Date());

        customerRepo.save(customer);
        accountRepo.save(account);

        // Set the relationship on both sides
        account.setCustomer(customer);

        // Update the references in mobileBankingUser
        mobileBankingUser.setCustomer(customer);
        mobileBankingUser.setAccount(account);

        // Then save the mobile banking user
        mobileBankingUserRepo.save(mobileBankingUser);

        return mobileBankingUser;
    }
}


