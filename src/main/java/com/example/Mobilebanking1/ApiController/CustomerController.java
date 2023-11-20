package com.example.Mobilebanking1.ApiController;
import com.example.Mobilebanking1.Model.*;
import com.example.Mobilebanking1.Repository.CustomerRepo;
import com.example.Mobilebanking1.Service.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@RestController
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping(value = "/viewCustomer")
    public List<Customer> viewCustomer(){
        return customerRepo.findAll();
    }
  @PostMapping(value = "/createCustomer")
    public String createcustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
        return "custumer saved";
    }
    @Autowired
    private Update update;
    @PutMapping(value = "/updateCustomer/{cif}")
    public String updateCustomer (@PathVariable Integer cif , @RequestBody Customer customer){
        return update.updateCustomer(cif, customer);
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return  update.deleteCustomer(id);
    }

}
