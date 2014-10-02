package com.realdolmen.travel.domain;

import javax.persistence.*;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Entity
public class User extends AbstractEntity {
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;
    @ManyToOne
    private Partner partner;

    protected User() {
    }

    public User(String userName, String password, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
