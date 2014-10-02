package com.realdolmen.travel.controller;

import com.realdolmen.travel.builder.FlightBuilder;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.repository.FlightRepository;
import com.realdolmen.travel.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Named
@RequestScoped
public class FlightController {
    @Inject
    FlightService flightService;
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Collection<Flight> flights;

    @PostConstruct
    public void initialize() {
      flights = flightService.findAll();
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public String test() {
        flights.add(FlightBuilder.flight().withDepartureDate(new Date()).withPrice(15.15).build());
        return "";
    }

    public Double calculateAveragePrice() {
        return flightService.calculateAveragePrice();
    }
    public Double calculateMinimumPrice(){
        return flightService.calculateMinimumPrice();
    }
    public Double calculateMaximumPrice(){
        return flightService.calculateMaximumPrice();
    }
    public Double testCalculateAveragePrice(Location departure, Location destination, Region departureRegion, Region destinationRegion) {
    return flightService.testCalculateAveragePrice(departure, destination, departureRegion, destinationRegion);
    }
}
