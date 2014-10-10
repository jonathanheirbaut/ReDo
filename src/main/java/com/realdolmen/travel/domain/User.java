package com.realdolmen.travel.domain;

import javax.persistence.*;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Entity
public class User extends AbstractEntity {
    private String userName;
    private String password;
/*    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;*/


    protected User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
