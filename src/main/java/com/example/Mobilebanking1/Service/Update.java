package com.example.Mobilebanking1.Service;
import com.example.Mobilebanking1.Model.*;

import com.example.Mobilebanking1.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Update {


    @Autowired
    private AccountRepo accountRepo;
    public String updateAcct(Integer acctID , Account account) {
        Account updateAcct = accountRepo.findById(acctID).get();
        updateAcct.setAccountStatus(account.getAccountStatus());
        updateAcct.setBalance(account.getBalance());
        updateAcct.setUpdatedDate(new Date());
        updateAcct.setCustomer(account.getCustomer());
        accountRepo.save(updateAcct);
        return "account updated  . . ."; }

    @Autowired
    private CustomerRepo customerRepo;

    public String updateCustomer(Integer cif , Customer customer){
        Optional<Customer> optionalCustomer = customerRepo.findById(cif);
        if(optionalCustomer.isPresent()) {
            Customer updateCustomer = optionalCustomer.get();
            updateCustomer.setCity(customer.getCity());
            updateCustomer.setState(customer.getState());
            updateCustomer.setFirstName(customer.getFirstName());
            updateCustomer.setLastName(customer.getLastName());
            updateCustomer.setSalutations(customer.getSalutations());
            updateCustomer.setCustomerType(customer.getCustomerType());
            updateCustomer.setEmail(customer.getEmail());
            customerRepo.save(updateCustomer);
            return "Customer updated...";
        } else {
            throw new RuntimeException("Customer not found with cif: " + cif);
        }
    }
    @Autowired
    private MobileBankingUserRepo mobileBankingUserRepo;
    public String updateMBuser(Integer userID , MobileBankingUser mobileBankingUser) {
        MobileBankingUser updateMBuser = mobileBankingUserRepo.findById(userID).get();
        updateMBuser.setCustomer(mobileBankingUser.getCustomer());
        updateMBuser.setAccount(mobileBankingUser.getAccount());
        updateMBuser.setUsername(mobileBankingUser.getUsername());
        updateMBuser.setPin(mobileBankingUser.getPin());
        updateMBuser.setCustomer(mobileBankingUser.getCustomer());
        mobileBankingUserRepo.save(updateMBuser);
        return "user updated  . . ."; }

   // @Autowired
    //private CustomerRepo customerRepo;
    public String deleteCustomer(Integer id){
        customerRepo.deleteById(id);
        return "cystomer deleted ...";
    }



    }



