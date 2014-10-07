package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by JHRAU70 on 6/10/2014.
 */
@Entity
public class Booking extends AbstractEntity {
    @ManyToOne
    private Customer customer;


    protected Booking() {
    }
}
