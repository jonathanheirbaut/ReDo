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
    private Integer threshold;
    private Integer discount;

    protected Discount() {
    }

    public Discount(Integer threshold, Integer discount) {
        this.threshold = threshold;
        this.discount = discount;
    }

    public Long getVersion() {
        return version;
    }

    public Integer getId() {
        return id;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public Integer getDiscount() {
        return discount;
    }
}
