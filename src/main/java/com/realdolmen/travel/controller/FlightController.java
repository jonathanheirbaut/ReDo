package com.realdolmen.travel.controller;

import com.realdolmen.travel.builder.FlightBuilder;
import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Partner;
import com.realdolmen.travel.domain.Region;
import com.realdolmen.travel.service.FlightService;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class FlightController {
    private LazyDataModel<Flight> lazyModel;

    @Inject
    FlightService flightService;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Region departureRegion;
    private Region destinationRegion;
    private Date startDate;
    private Date endDate;
    private Partner partner;
    private Flight flight;

    private Collection<Flight> flights;


    @PostConstruct
    public void initialize() {
        flights = flightService.findAll();
        lazyModel = new LazyFlightModel(flightService.findAll());
    }

    public LazyDataModel<Flight> getLazyModel() {
        return lazyModel;
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public String test() {
        flights.add(FlightBuilder.flight().withDepartureDate(new Date()).withPrice(15.15).build());
        return "";
    }

    public Double calculateMinimumPrice() {
        return flightService.calculateMinimumPrice(departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public Double calculateMaximumPrice() {
        return flightService.calculateMaximumPrice(departureRegion, destinationRegion, startDate, endDate, partner);
    }

    public Double calculateAveragePrice() {
        return flightService.calculateAveragePrice(departureRegion, destinationRegion, startDate, endDate, partner);
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public void doSomeThing() {
        logger.info("the selected date is " + getStartDate());
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Flight> findAllByPartner(Partner partner) {
        return flightService.findAllByPartner(partner);
    }

    public Collection<Partner> findAllPartners() {
        return flightService.findAllPartners();
    }

    public void create() {
        flightService.create(flight);
    }


}
