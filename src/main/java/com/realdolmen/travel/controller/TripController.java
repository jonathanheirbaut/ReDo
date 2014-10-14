package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@ManagedBean
@ViewScoped
public class TripController  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    private TripService tripService;
    @Inject
    private UserController userController;
    private List<Trip> allTrips;
    private List<Trip> availableTrips;

    private Location departureLocation;
    private Location destinationLocation;
//  @Future
    private Date departureDate;
    private Date returnDate;
    private Integer numberOfPersons;


    @PostConstruct
    public void initialize() {
        allTrips = tripService.findAll();
    }

    public String saveTrip() {
        return null;
    }

    public void searchTrip() {
        availableTrips = tripService.getAvailableTripsBySearchValues(departureLocation, destinationLocation, departureDate, addHoursToDate(returnDate), numberOfPersons);
        userController.setNumberOfPersons(numberOfPersons);
//        userController.setSelectedTrip(null);
        for (Trip availableTrip : availableTrips) {
            logger.info(availableTrip.getName());
        }
    }

    public Double getTripPrice(Trip trip, int numberOfPersons){
       return tripService.calculateTripPrice(trip, numberOfPersons).doubleValue();
    }

    public List<Trip> getAllTrips() {
        return allTrips;
    }


    public Location getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(Location departureLocation) {
        this.departureLocation = departureLocation;
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

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public List<Trip> getAvailableTrips() {
        return availableTrips;
    }

    public void setAvailableTrips(List<Trip> availableTrips) {
        this.availableTrips = availableTrips;
    }

    private Date addHoursToDate(Date date) {
        Calendar dep = Calendar.getInstance();
        dep.setTime(date);
        dep.add(Calendar.HOUR, 23);
        dep.add(Calendar.MINUTE,59);
        dep.add(Calendar.SECOND,59);
        Date newDate = new Date(dep.getTimeInMillis());
        return newDate;
    }
}
