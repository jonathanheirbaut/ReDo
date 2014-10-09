package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.service.TripService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Named
@RequestScoped
public class TripController {
    @Inject
    private TripService tripService;
    private List<Trip> trips;

    private Region departureRegion;
    private Location departureLocation;
    private Region destinationRegion;
    private Location destinationLocation;
    private Date departureDate;
    private Date returnDate;
    private int numberOfPersons;


    @PostConstruct
    public void initialize() {
        trips = tripService.findAll();
    }

    public String saveTrip(){
        return null;
    }

    public String searchTrip(){
        return null;
    }

    public void onDepartureRegionChange() {

    }

    public List<Trip> getTrips() {
        return trips;
    }

    public Region getDepartureRegion() {
        return departureRegion;
    }

    public void setDepartureRegion(Region departureRegion) {
        this.departureRegion = departureRegion;
    }

    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
    }

    public Region getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(Region destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
