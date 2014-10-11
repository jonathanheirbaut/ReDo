package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by JHRAU70 on 6/10/2014.
 */
@Entity
public class Booking extends AbstractEntity {
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Trip trip;
    private Integer numberOfPeople;
    private Double price;


    public Booking() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
