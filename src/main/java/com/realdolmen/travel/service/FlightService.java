package com.realdolmen.travel.service;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.FlightRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class FlightService {
    private Collection<Flight> flights;

    @Inject
    private FlightRepository flightRepository;

    public Double calculateAveragePrice() {
        return flightRepository.calculateAveragePrice();
    }
    public Double calculateMinimumPrice(){
        return flightRepository.calculateMinimumPrice();
    }
    public Double calculateMaximumPrice(){
        return flightRepository.calculateMaximumPrice();
    }
    public Collection<Flight> findAll() {
        return flightRepository.findAll();
    }
    public Double testCalculateAveragePrice(Location departure, Location destination, Region departureRegion, Region destinationRegion) {
       return flightRepository.testCalculateAveragePrice(departure,destination, departureRegion, destinationRegion);
    }
}


