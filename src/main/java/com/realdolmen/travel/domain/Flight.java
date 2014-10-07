package com.realdolmen.travel.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight extends AbstractEntity{

    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;
    private Double price;
    private Double overriddenPrice;
    @ManyToOne
    @JoinColumn(name="location_fk")
    private Location destination;
    @ManyToOne
    private Location departure;
    @ManyToOne
    private Partner partner;
    private Integer maxSeats;

    public Flight() {
    }

    public Flight(Date departureDate, Date arrivalDate, Double price, Double overriddenPrice, Location departure, Location destination, Partner partner, Integer maxSeats) {
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOverriddenPrice() {
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

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setOverriddenPrice(Double overriddenPrice) {
        this.overriddenPrice = overriddenPrice;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }
}
