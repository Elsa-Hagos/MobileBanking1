package com.example.Mobilebanking1.Model;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.*;
import com.fasterxml.jackson.annotation.*;
//import java.sql.Date;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cif;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> account = new ArrayList<>();
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MobileBankingUser> mobileBankingUsers = new ArrayList<>();

    private String firstName;
    private String lastName;
    private String salutations;
    private String email;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    private String city;
    private String state;
    private String mobilePhone;
    private String homePhone;
    private String customerType;

    // Getters and Setters
    public int getCif() {
        return cif;
    }
    public void setCif(int cif) {
        this.cif = cif;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getSalutations() {
        return salutations;
    }
    public void setSalutations(String salutations) {
        this.salutations = salutations;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public Date getDob() {return dob;}
    public void setDob(Date dob) {
        this.dob = dob;
    }


    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public String getHomePhone() {
        return homePhone;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }


    public String getCustomerType() {
        return customerType;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}



