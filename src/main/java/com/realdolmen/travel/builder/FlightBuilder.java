package com.realdolmen.travel.builder;

import com.realdolmen.travel.domain.Flight;
import com.realdolmen.travel.domain.Location;
import com.realdolmen.travel.domain.Partner;

import java.util.Date;

/**
 * Created by JHRAU70 on 1/10/2014.
 */
public class FlightBuilder {
    private Date departureDate;
    private Date arrivalDate;
    private Double price;
    private Double overriddenPrice;
    private Location destination;
    private Location departure;
    private Partner partner;
    private Integer maxSeats;

    private FlightBuilder() {

    }

    public static FlightBuilder flight() {
        return new FlightBuilder();
    }

    public Flight build() {
        Flight flight = new Flight();
        flight.setDepartureDate(departureDate);
        flight.setPrice(price);
        return flight;
    }

    public FlightBuilder withDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public FlightBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }
}
