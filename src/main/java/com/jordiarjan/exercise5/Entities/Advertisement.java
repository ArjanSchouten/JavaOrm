package com.jordiarjan.exercise5.Entities;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by jordi_000 on 17-6-2015.
 */

@Entity
@Table(name="advertisement")
public abstract class Advertisement {

    @Id @GeneratedValue
    private Long id;

    @Column( name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column( name= "startPrice")
    private int startPrice;

    @Column(name="active")
    private boolean active;

    @Column( name="startDate")
    private Date startDate;

    @OneToMany(mappedBy = "advertisement")
    private List<AdvertisementReaction> reactions;
}
