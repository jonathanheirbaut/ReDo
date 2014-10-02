package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Entity
public class User extends AbstractEntity {
    private String userName;
    private String password;

    @ManyToOne
    private Partner partner;

}
