package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.TripServiceException;
import com.realdolmen.travel.service.FlightService;
import com.realdolmen.travel.service.TripService;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.SelectableDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

/**
 * Created by KVEAU50 on 8/10/2014.
 */
@Named
@RequestScoped

public class AddTripController {
    @Inject
    TripService tripService;
    @Inject
    UserController userController;

    private Trip trip;
    private String name;
    @Min(value = 1, message = "The minimal amount is 1")
    private Integer emptyPlaces;
    private Flight outwardFlight;
    private Flight returnFlight;

    Logger logger = LoggerFactory.getLogger(AddFlightController.class);



    public String createTrip() {

        try{
            Trip trip = new Trip();
            trip.setEmptyPlaces(emptyPlaces);
            trip.setName(name);

            trip.setOutwardFlight(outwardFlight);
            trip.setReturnFlight(returnFlight);
            tripService.create(trip);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Your trip has been submitted!"));

            emptyPlaces = null;
            name = null;
        }catch (TripServiceException ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "You have to select 2 flights", ""));
            return null;
        }


        return null;
    }

    public Integer getEmptyPlaces() {
        return emptyPlaces;
    }

    public void setEmptyPlaces(Integer emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
    }

    public Flight getOutwardFlight() {
        return outwardFlight;
    }

    public void setOutwardFlight(Flight outwardFlight) {
        this.outwardFlight = outwardFlight;
    }

    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onSelectOutwardFlight(SelectEvent event) {
        logger.info("I selected an item");
        setOutwardFlight((Flight) event.getObject());
    }
    public void onSelectReturnFlight(SelectEvent event) {

        logger.info("I selected an item");
        setReturnFlight((Flight) event.getObject());

    }
    public void doSomething(){
        logger.info("i'm here");
        logger.info("outward flight: " + getOutwardFlight());

    }


}
