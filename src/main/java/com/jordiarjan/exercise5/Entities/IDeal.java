package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;

/**
 * Created by Arjan on 16/06/2015.
 */
@Entity
@Table(name = "ideal")
@PrimaryKeyJoinColumn(name = "payment_data_id", referencedColumnName = "id")
public class IDeal extends PaymentData {

    private int expirationMonth;

    private int experiationYear;
}
