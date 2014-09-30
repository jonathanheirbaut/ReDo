package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Discount {

    @Version
    private Long version;
    @Id @GeneratedValue
    private Integer id;
    private int threshold;
    private int discount;

    public Discount() {
    }

    public Discount(int threshold, int discount) {
        this.threshold = threshold;
        this.discount = discount;
    }

    public Long getVersion() {
        return version;
    }

    public Integer getId() {
        return id;
    }

    public int getThreshold() {
        return threshold;
    }

    public int getDiscount() {
        return discount;
    }
}
