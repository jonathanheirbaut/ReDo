package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.domain.UserType;
import com.realdolmen.travel.exception.UserServiceException;
import com.realdolmen.travel.service.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ResourceBundle;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Named
@SessionScoped
public class UserController implements Serializable {
    @EJB
    private UserService userService;

    private User user;

    public UserController() {
    }

    public String login(String username, String password){
        try {
            userService.checkLogin(username, password);
            user = userService.getUser(username);
            return "2";
        } catch (UserServiceException ex) {
            // ResourceBundle bundle = ResourceBundle.getBundle("be.kdg.repaircafe.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Wachtwoord is compleet verkeerd", ""));
            return "index";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
