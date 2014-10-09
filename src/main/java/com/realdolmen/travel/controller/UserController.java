package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.*;
import com.realdolmen.travel.exception.UserServiceException;
import com.realdolmen.travel.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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

    public boolean userIsOfTypeAirlineEmployee() {
        return (user instanceof AirlineEmployee);
    }

    public boolean userIsOfTypeCustomer() {
        return (user instanceof Customer);
    }


    public boolean userIsOfTypeRDAirEmployee() {
        return (user instanceof RDAirEmployee);
    }


    public boolean userIsOfTypeRDTravelEmployee() {
        return (user instanceof RDTravelEmployee);
    }

    public AirlineEmployee getUserAsAirlineEmployee() {
        if (userIsOfTypeAirlineEmployee()) {
            return (AirlineEmployee) user;
        }
        throw new IllegalStateException("User is not of type AirlineEmployee");
    }

    public Customer getUserAsCustomer() {
        if (userIsOfTypeCustomer()) {
            return (Customer) user;
        }
        throw new IllegalStateException("User is not of type Customer");
    }

    public RDAirEmployee getUserAsRDAirEmployee() {
        if (userIsOfTypeRDAirEmployee()) {
            return (RDAirEmployee) user;
        }
        throw new IllegalStateException("User is not of type RDAirEmployee");
    }

    public RDTravelEmployee getUserAsRDTravelEmployee() {
        if (userIsOfTypeRDTravelEmployee()) {
            return (RDTravelEmployee) user;
        }
        throw new IllegalStateException("User is not of type RDTravelEmployee");
    }


    public String login(String username, String password) {
        try {
            userService.checkLogin(username, password);
            user = userService.getUser(username);
            loggedIn = true;
            if (userIsOfTypeCustomer()) return "addbooking";
            if (userIsOfTypeAirlineEmployee()) return "flights";
            if (userIsOfTypeRDAirEmployee()) return "flight_stats";
            if (userIsOfTypeRDTravelEmployee()) return "add_trip";
            return "";
        } catch (UserServiceException ex) {
            // ResourceBundle bundle = ResourceBundle.getBundle("com.realdolmen.travel.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Foutief wachtwoord of gebruikersnaam", ""));
            return "";
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "index";
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
