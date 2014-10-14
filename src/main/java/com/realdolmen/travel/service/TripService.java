package com.realdolmen.travel.service;

import com.realdolmen.travel.controller.AddFlightController;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Trip;
import com.realdolmen.travel.exception.TripServiceException;
import com.realdolmen.travel.repository.FlightRepository;
import com.realdolmen.travel.repository.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 8/10/2014.
 */
@Stateless
public class TripService {
    @Inject
    private TripRepository tripRepository;
    @Inject
    private FlightRepository flightRepository;

    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    Logger logger = LoggerFactory.getLogger(AddFlightController.class);

    public void create(Trip trip) throws TripServiceException {
        if (trip.getOutwardFlight() == null || trip.getReturnFlight() == null) {
            throw new TripServiceException("You have to select 2 flights!");
        }
        if (trip.getOutwardFlight().getId().equals(trip.getReturnFlight().getId())) {
            throw new TripServiceException("You have to select 2 different flights!");
        }
        if(trip.getEmptyPlaces()> trip.getOutwardFlight().getEmptySeats()){
            throw new TripServiceException("You have to select an outward flight with enough empty seats!");
        }
        if(trip.getEmptyPlaces()> trip.getOutwardFlight().getEmptySeats()){
            throw new TripServiceException("You have to select a return flight with enough empty seats!");
        }


        if (trip.getOutwardFlight().getArrivalDate().compareTo(trip.getReturnFlight().getDepartureDate()) == 1 ||
                trip.getOutwardFlight().getArrivalDate() == trip.getReturnFlight().getDepartureDate()) {
            throw new TripServiceException("The 2 dates don't match");
        }
        Flight outwardFlight = trip.getOutwardFlight();
        Flight returnFlight = trip.getReturnFlight();
        outwardFlight.setEmptySeats(outwardFlight.getEmptySeats() - trip.getEmptyPlaces());
        returnFlight.setEmptySeats(returnFlight.getEmptySeats()-trip.getEmptyPlaces());
        flightRepository.update(outwardFlight);
        flightRepository.update(returnFlight);
        tripRepository.create(trip);
    }

    public BigDecimal calculateTripPrice(Trip trip, int numberOfPersons) {
        return tripRepository.calculateTripPrice(trip.getOutwardFlight().getDestination(), trip.getOutwardFlight(), trip.getReturnFlight(), numberOfPersons);
    }


    public List<Trip> getAvailableTripsBySearchValues(Location departureLocation, Location destinationLocation, Date departureDate, Date returnDate, Integer numberOfPersons) {
        return tripRepository.getAvailableTripsBySearchValues(departureLocation, destinationLocation, departureDate, returnDate, numberOfPersons);
    }

    public Trip findById(Long tripId) {
       return tripRepository.find(tripId);
    }
}

