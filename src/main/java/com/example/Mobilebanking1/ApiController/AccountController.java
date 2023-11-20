package com.example.Mobilebanking1.ApiController;
import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Repository.*;
import com.example.Mobilebanking1.Service.*;
import org.springframework.beans.factory.annotation.*;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping(value = "/viewAcct")
    public List<Account> viewAcct() {
        return accountRepo.findAll();
    }

@Autowired
private Create create;
@PostMapping(value = "/createAcct")
    public ResponseEntity<Account> createAcct(@RequestBody Account account) {
        Account createAc = create.createAccount(account);
        return new ResponseEntity<>(createAc, HttpStatus.CREATED);
    }


    @Autowired
    private Update update;
    @PutMapping(value = "/updateAcct/{acctID}")
     public String updateAcct (@PathVariable Integer acctID , @RequestBody Account account){
        return update.updateAcct(acctID, account);
     }

    @Autowired
    private BalanceInquiry balanceInquiry;

    @GetMapping("/balance/{acctId}")
    public ResponseEntity<Double> getAccountBalance(@PathVariable int acctId) {
        double balance = balanceInquiry.getAccountBalance(acctId);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }




}











