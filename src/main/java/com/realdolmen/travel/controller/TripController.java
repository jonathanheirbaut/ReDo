package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.service.TripService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    public List<Trip> getTrips() {
        return trips;
    }
}
