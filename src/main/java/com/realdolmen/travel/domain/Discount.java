package com.realdolmen.travel.domain;

import javax.persistence.*;

@Entity
public class Discount extends AbstractEntity {
    private Integer threshold;
    private Double discount;
    @ManyToOne
    private Partner partner;


    public Discount() {
    }

    public Long getVersion() {
        return version;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
