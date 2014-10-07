package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by JHRAU70 on 7/10/2014.
 */
@Entity
public class AirlineEmployee extends User{
    @ManyToOne
    private Partner partner;

    protected AirlineEmployee() {
    }

    public AirlineEmployee(String userName, String password, Partner partner) {
        super(userName, password);
        this.partner = partner;
    }
}
