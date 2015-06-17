package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Arjan on 17/06/2015.
 */
@Entity
@Table(name = "offer")
public class Offer {

    @Id @GeneratedValue
    private long Id;

    private int price;

    private Date date;

    @ManyToOne
    private User user;
}
