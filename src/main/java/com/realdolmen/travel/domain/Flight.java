package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {
    @Version
    private Long version;
    @Id
    @GeneratedValue
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;
    private double price;
    private double overriddenPrice;
    @ManyToOne
    private Location destination;
    @ManyToOne
    private Location departure;
    @ManyToOne
    private Partner partner;
    private int maxSeats;

    public Flight() {
    }

    public Flight(Date departureDate, Date arrivalDate, double price, double overriddenPrice, Location departure, Location destination, Partner partner, int maxSeats) {
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.overriddenPrice = overriddenPrice;
        this.departure = departure;
        this.destination = destination;
        this.partner = partner;
        this.maxSeats = maxSeats;
    }

    public Long getVersion() {
        return version;
    }

    public Integer getId() {
        return id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public double getPrice() {
        return price;
    }

    public double getOverriddenPrice() {
        return overriddenPrice;
    }

    public Location getDeparture() {
        return departure;
    }

    public Location getDestination() {
        return destination;
    }

    public Partner getPartner() {
        return partner;
    }

    public int getMaxSeats() {
        return maxSeats;
    }
}
