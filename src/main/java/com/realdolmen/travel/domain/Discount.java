package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Discount extends AbstractEntity {
    //HIER PARTNER BIJHOUDEN???
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

    public Integer getThreshold() {
        return threshold;
    }

    public Integer getDiscount() {
        return discount;
    }
}
