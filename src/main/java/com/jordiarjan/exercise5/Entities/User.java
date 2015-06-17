package com.jordiarjan.exercise5.Entities;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arjan on 16/06/2015.
 */
@Entity
@Table(name = "user")
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<PaymentData> paymentdatas = new ArrayList();

    @OneToMany(mappedBy = "sellingUser")
    private List<Advertisement> advertisements = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<PaymentData> getPaymentdatas() {
        return paymentdatas;
    }

    public void addPaymentData(PaymentData paymentdata) {
        this.paymentdatas.add(paymentdata);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
