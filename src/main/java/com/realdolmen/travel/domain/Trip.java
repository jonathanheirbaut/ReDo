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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (emptyPlaces != null ? !emptyPlaces.equals(trip.emptyPlaces) : trip.emptyPlaces != null) return false;
        if (name != null ? !name.equals(trip.name) : trip.name != null) return false;
        if (outwardFlight != null ? !outwardFlight.equals(trip.outwardFlight) : trip.outwardFlight != null)
            return false;
        if (returnFlight != null ? !returnFlight.equals(trip.returnFlight) : trip.returnFlight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (emptyPlaces != null ? emptyPlaces.hashCode() : 0);
        result = 31 * result + (outwardFlight != null ? outwardFlight.hashCode() : 0);
        result = 31 * result + (returnFlight != null ? returnFlight.hashCode() : 0);
        return result;
    }
}
