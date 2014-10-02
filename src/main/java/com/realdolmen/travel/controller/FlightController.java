package com.realdolmen.travel.controller;

import com.realdolmen.travel.builder.FlightBuilder;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.repository.FlightRepository;
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
    private FlightRepository flightRepository;
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Collection<Flight> flights;

    @PostConstruct
    public void initialize() {
      flights = flightRepository.findAll();
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public String test() {
        flights.add(FlightBuilder.flight().withDepartureDate(new Date()).withPrice(15.15).build());
        return "";
    }
}
