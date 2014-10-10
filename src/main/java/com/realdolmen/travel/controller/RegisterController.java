package com.realdolmen.travel.controller;

import com.realdolmen.travel.service.UserService;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by KVEAU50 on 10/10/2014.
 */
@Named
@ViewScoped
public class RegisterController {
    @Inject
    UserService userService;

    private String userName;
    private String password1;
    private String password2;


     

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
