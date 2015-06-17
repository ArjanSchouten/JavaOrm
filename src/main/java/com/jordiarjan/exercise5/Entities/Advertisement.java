package com.jordiarjan.exercise5.Entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jordi_000 on 17-6-2015.
 */

@Entity
@Table(name="advertisement")
public class Advertisement {

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

    @ManyToOne
    private User sellingUser;

    @ManyToOne
    private User purchasingUser;

    @OneToMany(mappedBy = "advertisement")
    private List<AdvertisementReaction> reactions;

    @OneToOne
    private Offer succesfullOffer;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public User getSellingUser() {
        return sellingUser;
    }

    public void setSellingUser(User sellingUser) {
        this.sellingUser = sellingUser;
    }

    public User getPurchasingUser() {
        return purchasingUser;
    }

    public void setPurchasingUser(User purchasingUser) {
        this.purchasingUser = purchasingUser;
    }

    public List<AdvertisementReaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<AdvertisementReaction> reactions) {
        this.reactions = reactions;
    }

    public Offer getSuccesfullOffer() {
        return succesfullOffer;
    }

    public void setSuccesfullOffer(Offer succesfullOffer) {
        this.succesfullOffer = succesfullOffer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
