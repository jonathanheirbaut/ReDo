package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Customer;
import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.exception.UserServiceException;
import com.realdolmen.travel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by KVEAU50 on 10/10/2014.
 */
@Named
@RequestScoped
public class RegisterController {
    @Inject
    UserService userService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    Customer customer;
    private String userName;
    private String password1;
    private String password2;

    public String register(){

        try{
            customer = new Customer();
            customer.setUserName(userName);
            userService.register(customer, password1);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"You have been successfully registered", ""));
            userName=null;
        }catch(UserServiceException ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,ex.getMessage(), ""));
        }

        return null;
    }

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
