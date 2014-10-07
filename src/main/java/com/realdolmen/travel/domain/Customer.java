package com.realdolmen.travel.domain;

import javax.persistence.Entity;

/**
 * Created by JHRAU70 on 7/10/2014.
 */
@Entity
public class Customer extends User {

    protected Customer() {
    }

    public Customer(String userName, String password) {
        super(userName, password);
    }
}
