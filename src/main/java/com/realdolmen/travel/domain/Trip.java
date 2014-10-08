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
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @ManyToOne
    private Flight outwardFlight;
    @ManyToOne
    private Flight returnFlight;
    @OneToMany
    @JoinColumn(name="trip_id")
    private List<Booking> bookings = new ArrayList<>();

    protected Trip() {
    }

    public Trip(String name, Date beginDate, Date endDate) {
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
