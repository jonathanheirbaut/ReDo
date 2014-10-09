package com.realdolmen.travel.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JHRAU70 on 6/10/2014.
 */
@Entity
public class Trip extends AbstractEntity {
    private String name;
    private Integer emptyPlaces;
    @ManyToOne
    private Flight outwardFlight;
    @ManyToOne
    private Flight returnFlight;
    @OneToMany
    @JoinColumn(name="trip_id")
    private List<Booking> bookings = new ArrayList<>();

    public Trip() {
    }

    public Trip(String name, Integer emptyPlaces, Flight outwardFlight, Flight returnFlight) {
        this.name = name;
        this.emptyPlaces = emptyPlaces;
        this.outwardFlight = outwardFlight;
        this.returnFlight = returnFlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Flight getOutwardFlight() {
        return outwardFlight;
    }

    public void setOutwardFlight(Flight outwardFlight) {
        this.outwardFlight = outwardFlight;
    }

    public Flight getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    public Integer getEmptyPlaces() {
        return emptyPlaces;
    }

    public void setEmptyPlaces(Integer emptyPlaces) {
        this.emptyPlaces = emptyPlaces;
    }
}
