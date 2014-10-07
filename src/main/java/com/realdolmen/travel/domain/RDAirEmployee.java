package com.realdolmen.travel.domain;

import javax.persistence.Entity;

/**
 * Created by JHRAU70 on 7/10/2014.
 */
@Entity
public class RDAirEmployee extends User {

    protected RDAirEmployee() {
    }

    public RDAirEmployee(String userName, String password) {
        super(userName, password);
    }
}
