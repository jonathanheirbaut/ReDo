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
    private Location departure;
    private Location destination;
    private Region departureRegion;
    private Region destinationRegion;

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

    public Region getDepartureRegion() {
        return departureRegion;
    }

    public void setDepartureRegion(Region departureRegion) {
        this.departureRegion = departureRegion;
    }

    public Region getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(Region destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }
}
