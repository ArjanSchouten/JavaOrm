package com.jordiarjan.exercise5.Entities;

import javax.persistence.*;

/**
 * Created by Arjan on 16/06/2015.
 */
@Entity
@Table(name = "creditcard")
@PrimaryKeyJoinColumn(name = "payment_data_id", referencedColumnName = "id")
public class CreditCard extends PaymentData {
    @Column
    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
