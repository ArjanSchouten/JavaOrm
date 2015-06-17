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
    private long id;

    private int price;

    private Date date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Advertisement advertisement;

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
