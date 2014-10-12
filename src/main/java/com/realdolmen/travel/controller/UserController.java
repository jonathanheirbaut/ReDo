package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.*;
import com.realdolmen.travel.exception.UserServiceException;
import com.realdolmen.travel.service.UserService;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by JHRAU70 on 2/10/2014.
 */
@Named
@SessionScoped
public class UserController implements Serializable {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @EJB
    private UserService userService;

    private User user;
    private boolean loggedIn;

    //Details about a selected trip before a booking
    private Trip selectedTrip;
    private Integer numberOfPersons;
    private String username;
    private String password;

    @PostConstruct
    public void init(){
        logger.info("UserController created");

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
            if (userIsOfTypeCustomer()) return "index";
            if (userIsOfTypeAirlineEmployee()) return "flights";
            if (userIsOfTypeRDAirEmployee()) return "flight_stats";
            if (userIsOfTypeRDTravelEmployee()) return "trips";
            return null;
        } catch (UserServiceException ex) {
            // ResourceBundle bundle = ResourceBundle.getBundle("com.realdolmen.travel.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_WARN, "Foutief wachtwoord of gebruikersnaam", ""));
            return null;
        }
    }

    public String loginPopup(String username, String password) {
        RequestContext context = RequestContext.getCurrentInstance();
        try {
            userService.checkLogin(username, password);
            user = userService.getUser(username);
            loggedIn = true;
            if (userIsOfTypeCustomer()) {
                context.addCallbackParam("loggedIn", true);
                logger.info("Loggedin callback true");
                return "confirmBooking";
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_INFO, "You have to be registered as a customer to make a booking", ""));
                logger.info("You have to be registered as a customer to make a booking");
            }
            context.addCallbackParam("loggedIn", false);
            logger.info("Loggedin callback false");
            return null;
        } catch (UserServiceException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_WARN, "Wrong credentials", ""));
            logger.info("Wrong credentials");
            context.addCallbackParam("loggedIn", false);
            logger.info("Loggedin callback false");
            return null;
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

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        if (selectedTrip != null){
            this.selectedTrip = selectedTrip;
        }
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public void resetBooking() {
        numberOfPersons = null;
        selectedTrip = null;
    }
}
