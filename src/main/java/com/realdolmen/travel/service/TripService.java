package com.realdolmen.travel.service;

import com.realdolmen.travel.controller.AddFlightController;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.TripServiceException;
import com.realdolmen.travel.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class TripService {
    @Inject
    private TripRepository tripRepository;

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    Logger logger = LoggerFactory.getLogger(AddFlightController.class);

    public void create(Trip trip) throws TripServiceException {


            if(trip.getOutwardFlight()==null || trip.getReturnFlight()==null){
                throw new TripServiceException("You have to select 2 flights!");
            }
            if(trip.getOutwardFlight().getId().equals(trip.getReturnFlight().getId())){
                throw new TripServiceException("You have to select 2 different flights!");
            }
        if(trip.getOutwardFlight().getArrivalDate().compareTo(trip.getReturnFlight().getDepartureDate()) == 1 ||
                trip.getOutwardFlight().getArrivalDate() == trip.getReturnFlight().getDepartureDate()){
            throw new TripServiceException("The 2 dates don't match");
        };

            tripRepository.create(trip);
        }

    }

