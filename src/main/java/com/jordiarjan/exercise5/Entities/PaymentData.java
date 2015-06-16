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
}
