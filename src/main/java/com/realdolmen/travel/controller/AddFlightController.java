package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.AirlineEmployee;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.util.Calendar;
import java.util.Date;

@Named
@RequestScoped
public class AddFlightController {
    @Inject
    FlightService flightService;

    @Inject
    UserController userController;
    private Flight flight;
    @Min(value = 1, message = "the minimal amount is 1")
    private Integer maxSeats;
    private Partner partner;
    @Future
    private Date departureDate;
    private Date duration;
    private Date arrivalDate;
    @Min(value = 1,message = "The minimum price is 1")
    private Double price;
    private Location departure;
    private Location destination;

    Logger logger = LoggerFactory.getLogger(AddFlightController.class);
    public String createFlight() {
        flight = new Flight();
        flight.setEmptySeats(maxSeats);
        flight.setDepartureDate(departureDate);
        flight.setArrivalDate(addDurationToDate(departureDate, duration));
        logger.info(departure.getName());
        flight.setPrice(price);
        flight.setDeparture(departure);
        flight.setDestination(destination);
        flight.setPartner(((AirlineEmployee)userController.getUser()).getPartner());
        flightService.create(flight);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Your flight has been submitted!"));
        maxSeats=null;
        price=null;
        departureDate=null;
        departure=null;
        destination=null;
        arrivalDate=null;
        duration=null;


        return null;
    }

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Location getDeparture() {
        return departure;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    private Date addDurationToDate(Date departureDate, Date duration) {
        Calendar dep = Calendar.getInstance();
        dep.setTime(departureDate);
        Calendar dur = Calendar.getInstance();
        dur.setTime(duration);
        dep.add(Calendar.HOUR, dur.get(Calendar.HOUR));
        dep.add(Calendar.MINUTE, dur.get(Calendar.MINUTE));
        Date arrivalDate = new Date(dep.getTimeInMillis());
        return arrivalDate;
    }

}
