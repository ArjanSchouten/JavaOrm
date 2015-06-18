package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jordi_000 on 17-6-2015.
 */

@Entity
@Table(name="advertisement_reaction")
public class AdvertisementReaction {

    @Id @GeneratedValue
    private Long id;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private Date date;

    @ManyToOne
    private Advertisement advertisement;

    @ManyToOne
    private User user;

    public void setText( String text ){ this.text = text; }

    public String getText() { return this.text; }

    public void setDate( Date date ) { this.date = date; }

    public Date getDate() { return this.date; }

    public void setAdvertisement( Advertisement advertisement ) { this.advertisement = advertisement; }

    public Advertisement getAdvertisement() { return this.advertisement; }

    public void setUser( User user ) { this.user = user; }
}
