package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by jordi_000 on 17-6-2015.
 */

@Entity
@Table(name="advertisement_reaction")
public abstract class AdvertisementReaction {

    @Id @GeneratedValue
    private Long id;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private Date date;

    @ManyToOne
    private Advertisement advertisement;
}
