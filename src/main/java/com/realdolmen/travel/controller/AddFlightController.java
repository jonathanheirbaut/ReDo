package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.service.FlightService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
    private Integer maxSeats;
    private Partner partner;
    private Date departureDate;
    private Date duration;
    private Date arrivalDate;
    private Double price;


    public void create(){
        flight = new Flight();
        flight.setMaxSeats(maxSeats);
        flight.setDepartureDate(departureDate);
        System.out.println("arrival date is = " + addDurationToDate(departureDate, duration));
        flight.setArrivalDate(addDurationToDate(departureDate, duration));
        flight.setPrice(price);
        flightService.create(flight);}

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

    private Date addDurationToDate(Date departureDate, Date duration){
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
