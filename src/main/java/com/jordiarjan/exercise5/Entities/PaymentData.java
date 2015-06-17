package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;

/**
 * Created by Arjan on 16/06/2015.
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="payment_data")
public abstract class PaymentData {

    @Id @GeneratedValue
    private Long id;

    @Column
    private int number;
    @Column(name = "owner_name")
    private String ownerName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
