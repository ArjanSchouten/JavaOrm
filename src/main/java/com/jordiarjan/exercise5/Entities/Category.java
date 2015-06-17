package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arjan on 17/06/2015.
*/
@Entity
@Table(name = "category")
public class Category {

    @Id @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<Category> subCategory) {
        this.subCategory = subCategory;
    }

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    private String name;

    @OneToMany(mappedBy = "parent")
    private List<Category> subCategory = new ArrayList<>();
}