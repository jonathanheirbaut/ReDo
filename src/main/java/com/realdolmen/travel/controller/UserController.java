package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.exception.UserServiceException;
import com.realdolmen.travel.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Named
@SessionScoped
public class UserController implements Serializable {
    @EJB
    private UserService userService;

    private User user;
    private boolean loggedIn;

    public UserController() {
    }

    public String login(String username, String password){
        try {
            userService.checkLogin(username, password);
            user = userService.getUser(username);
            loggedIn = true;
            return "2";
        } catch (UserServiceException ex) {
            // ResourceBundle bundle = ResourceBundle.getBundle("com.realdolmen.travel.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Foutief wachtwoord of gebruikersnaam", ""));
            return "";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
