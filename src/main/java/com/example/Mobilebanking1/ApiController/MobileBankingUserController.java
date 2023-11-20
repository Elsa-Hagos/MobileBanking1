package com.example.Mobilebanking1.ApiController;

import org.springframework.http.*;
import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Repository.*;
import com.example.Mobilebanking1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MobileBankingUserController {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    AccountRepo accountRepo;

    @Autowired
    private MobileBankingUserRepo mobileBankingUserRepo;


    @GetMapping(value = "/viewMBuser")
    public List<MobileBankingUser> viewMBuser() {
        return mobileBankingUserRepo.findAll();
    }
    @Autowired
    private Update update;
    @PutMapping(value = "/updateMBuser/{userID}")
    public String updateMBuser (@PathVariable Integer userID , @RequestBody MobileBankingUser mobileBankingUser){
        return update.updateMBuser(userID, mobileBankingUser);
    }
    @Autowired
    private Create create;

    @PostMapping (value = "/createMBuser")
    public ResponseEntity<MobileBankingUser> createMobileBankingUser(@RequestBody MobileBankingUser mobileBankingUser) {
        MobileBankingUser createdUser = create.createMobileBankingUser(mobileBankingUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /*
        @PostMapping (value = "/createMBuser")
        public ResponseEntity<MobileBankingUser> createMobileBankingUser(@RequestBody MobileBankingUser mobileBankingUser) {
            // Save the customer and account first
            Customer customer = mobileBankingUser.getCustomer();
            Account account = mobileBankingUser.getAccount();
            customerRepo.save(customer);
            accountRepo.save(account);

            // Set the relationship on both sides
            account.setCustomer(customer);

            // Update the references in mobileBankingUser
            mobileBankingUser.setCustomer(customer);
            mobileBankingUser.setAccount(account);

            // Then save the mobile banking user
            mobileBankingUserRepo.save(mobileBankingUser);

            return new ResponseEntity<>(mobileBankingUser, HttpStatus.CREATED);
        }*/
    }


