package com.realdolmen.travel.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JHRAU70 on 6/10/2014.
 */
@Entity
public class Trip extends AbstractEntity {
    private String name;
    @ManyToOne
    private Location destination;
    @OneToMany
    @JoinColumn(name="booking_fk")
    private List<Booking> bookings = new ArrayList<>();

    protected Trip() {
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

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
